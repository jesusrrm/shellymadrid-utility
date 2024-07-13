package com.shellymadrid.utility.service.implementation;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.shellymadrid.utility.model.NetworkDevice;
import com.shellymadrid.utility.model.devices.common.ShellyGetDeviceInfo;
import com.shellymadrid.utility.service.NetworkDeviceDiscoveryService;
import com.shellymadrid.utility.service.restClient.ShellyDeviceInfoClient;

import io.quarkus.rest.client.reactive.QuarkusRestClientBuilder;
import jakarta.enterprise.context.ApplicationScoped;

import java.net.URI;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import jakarta.ws.rs.core.Response;

@ApplicationScoped
public class NetworkDeviceDiscoveryServiceImpl implements NetworkDeviceDiscoveryService {

    private static final int THREAD_POOL_SIZE = 512;
    private static final int TASK_TIMEOUT_MILISECONDS = 410;
    private static Set<NetworkDevice> networkDevices = new HashSet<>();

    @Override
    public Set<NetworkDevice> discoverNetworkDevices(String baseIp) {
        ExecutorService executorService = Executors.newFixedThreadPool(THREAD_POOL_SIZE);
        networkDevices = new HashSet<>();
        List<Callable<ResponseWithIp>> tasks = new ArrayList<>();
        for (int i = 1; i < 256; i++) {
            final String ipAddress = "http://" + baseIp + "." + i;

            System.out.println("Starting task for: " + ipAddress);

            final ShellyDeviceInfoClient client = QuarkusRestClientBuilder.newBuilder()
                    .baseUri(URI.create(ipAddress))
                    .build(ShellyDeviceInfoClient.class);

            Callable<ResponseWithIp> taskG1 = () -> {
                Response response = client.getDeviceInfoG1();
                return new ResponseWithIp(response, ipAddress);
            };
            Callable<ResponseWithIp> taskG2 = () -> {
                Response response = client.getDeviceInfoG2();
                return new ResponseWithIp(response, ipAddress);
            };
            // Callable<ResponseWithIp> taskG3 = () -> {
            // Response response = client.getDeviceStatusG3();
            // return new ResponseWithIp(response, ipAddress);
            // };
            tasks.add(taskG1);
            tasks.add(taskG2);
            // tasks.add(taskG3);
        }

        try {
            List<Future<ResponseWithIp>> futures = executorService.invokeAll(tasks);
            for (Future<ResponseWithIp> future : futures) {
                try {
                    ResponseWithIp responseWithIp = future.get(TASK_TIMEOUT_MILISECONDS, TimeUnit.MILLISECONDS);
                    Response response = responseWithIp.getResponse();
                    String ip = responseWithIp.getIpAddress();
                    if (response.getHeaders().get("Server").toString().contains("Shelly")) {
                        String jsonString = response.readEntity(String.class);

                        // Create an ObjectMapper instance
                        ObjectMapper objectMapper = new ObjectMapper();

                        // Deserialize JSON string to Object11
                        ShellyGetDeviceInfo shellyGetDeviceInfo = objectMapper.readValue(jsonString,
                                ShellyGetDeviceInfo.class);

                        System.out.println("Se ha localizado un dispositivo Shelly: " + ip);
                        synchronized (networkDevices) {
                            networkDevices.add(new NetworkDevice(ip, shellyGetDeviceInfo));
                        }
                    }

                } catch (StreamReadException e) {
                    e.printStackTrace();
                } catch (DatabindException e) {
                    e.printStackTrace();
                } catch (JsonProcessingException e) {
                    e.printStackTrace();
                } catch (TimeoutException e) {

                    // } catch (TimeoutException e) {
                } catch (Exception e) {

                }
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            // Shutdown the executor service gracefully
            executorService.shutdown();
            try {
                if (!executorService.awaitTermination(60, TimeUnit.SECONDS)) {
                    executorService.shutdownNow();
                }
            } catch (InterruptedException e) {
                executorService.shutdownNow();
                Thread.currentThread().interrupt();
            }
        }

        return networkDevices;
    }

    private final class ResponseWithIp {
        private Response response;
        private String ipAddress;

        public ResponseWithIp(Response response, String ipAddress) {
            this.response = response;
            this.ipAddress = ipAddress;
        }

        public Response getResponse() {
            return response;
        }

        public String getIpAddress() {
            return ipAddress;
        }

    }

    @Override
    public Set<NetworkDevice> getDiscoveredNetworkDevices() {
        return networkDevices;
    }
}