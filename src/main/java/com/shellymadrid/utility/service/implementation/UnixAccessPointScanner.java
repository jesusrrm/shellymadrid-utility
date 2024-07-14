package com.shellymadrid.utility.service.implementation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import com.shellymadrid.utility.model.AccessPoint;
import com.shellymadrid.utility.service.AccessPointScanner;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class UnixAccessPointScanner implements AccessPointScanner {

    @Override
    public List<AccessPoint> scan() {
        List<AccessPoint> accessPoints = new ArrayList<>();
        try {
            // Process process = Runtime.getRuntime().exec("iwlist wlan0 scanning");

            ProcessBuilder processBuilder = new ProcessBuilder("iwlist wlan0 scanning", "-s");
            Process process = processBuilder.start();
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.trim().startsWith("ESSID")) {
                    accessPoints.add(new AccessPoint(line.trim()));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return accessPoints;
    }
}
