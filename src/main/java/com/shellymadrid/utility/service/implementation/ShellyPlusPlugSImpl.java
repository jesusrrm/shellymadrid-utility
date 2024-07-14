package com.shellymadrid.utility.service.implementation;

import com.shellymadrid.utility.service.restClient.ShellyPlusPlugS_G2;
import io.quarkus.rest.client.reactive.QuarkusRestClientBuilder;
import jakarta.enterprise.context.ApplicationScoped;
import java.net.URI;
import com.shellymadrid.utility.service.devices.ShellyPlusPlugSService;

@ApplicationScoped
public class ShellyPlusPlugSImpl implements ShellyPlusPlugSService {

    private ShellyPlusPlugS_G2 createClient(String ip) {
        String uri = "http://" + ip;
        return QuarkusRestClientBuilder.newBuilder()
                .baseUri(URI.create(uri))
                .build(ShellyPlusPlugS_G2.class);
    }

    @Override
    public void turnOnChannel1(String ip) {

        final ShellyPlusPlugS_G2 shellyPlusPlugS_G2 = createClient(ip);

        String jsonPayload = String.format("{\"id\":1,\"method\":\"Switch.Set\",\"params\":{\"id\":%d,\"on\":%b}}", 0,
                true);

        shellyPlusPlugS_G2.setSwitch(jsonPayload);
    }

    @Override
    public void turnOffChannel1(String ip) {
        final ShellyPlusPlugS_G2 shellyPlusPlugS_G2 = createClient(ip);

        String jsonPayload = String.format("{\"id\":1,\"method\":\"Switch.Set\",\"params\":{\"id\":%d,\"on\":%b}}", 0,
                false);
        shellyPlusPlugS_G2.setSwitch(jsonPayload);
    }

    @Override
    public void turnOnChannel2(String ip) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'turnOnChannel2'");
    }

    @Override
    public void turnOffChannel2(String ip) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'turnOffChannel2'");
    }

    @Override
    public void turnOnChannel3(String ip) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'turnOnChannel3'");
    }

    @Override
    public void turnOffChannel3(String ip) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'turnOffChannel3'");
    }

    @Override
    public DeviceStatus getStatus(String ip) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getStatus'");
    }

    @Override
    public ShellyDevice getShellyDevice(String ip) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getShellyDevice'");
    }

}
