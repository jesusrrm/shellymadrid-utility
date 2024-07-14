package com.shellymadrid.utility.service.implementation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import com.shellymadrid.utility.model.AccessPoint;
import com.shellymadrid.utility.service.AccessPointScanner;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class WindowsAccessPointScanner implements AccessPointScanner {

    @Override
    public List<AccessPoint> scan() {
        List<AccessPoint> accessPoints = new ArrayList<>();
        try {
            ProcessBuilder processBuilder = new ProcessBuilder("netsh wlan show networks mode=Bssid", "-s");
            Process process = processBuilder.start();

            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.trim().startsWith("SSID")) {
                    accessPoints.add(new AccessPoint(line.trim()));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return accessPoints;
    }
}
