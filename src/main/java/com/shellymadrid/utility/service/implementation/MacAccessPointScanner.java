package com.shellymadrid.utility.service.implementation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import com.shellymadrid.utility.model.AccessPoint;
import com.shellymadrid.utility.service.AccessPointScanner;
import java.io.IOException;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class MacAccessPointScanner implements AccessPointScanner {

    @Override
    public List<AccessPoint> scan() {
        List<AccessPoint> accessPoints = new ArrayList<>();
        try {
            ProcessBuilder processBuilder = new ProcessBuilder(
                    "/System/Library/PrivateFrameworks/Apple80211.framework/Versions/Current/Resources/airport", "-s");
            Process process = processBuilder.start();

            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                if (!line.trim().isEmpty() && !line.startsWith("SSID")) {
                    String[] parts = line.trim().split("\\s+");
                    if (parts.length > 0) {
                        accessPoints.add(new AccessPoint(parts[0]));
                    }
                }
            }

            // Wait for the process to complete
            int exitCode = process.waitFor();
            if (exitCode != 0) {
                throw new IOException("Failed to execute airport command, exit code: " + exitCode);
            }

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        return accessPoints;
    }
}
