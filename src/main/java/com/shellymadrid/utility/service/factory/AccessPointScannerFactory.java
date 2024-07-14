package com.shellymadrid.utility.service.factory;

import com.shellymadrid.utility.service.AccessPointScanner;
import com.shellymadrid.utility.service.implementation.WindowsAccessPointScanner;
import com.shellymadrid.utility.service.implementation.UnixAccessPointScanner;
import com.shellymadrid.utility.service.implementation.MacAccessPointScanner;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.Produces;

@ApplicationScoped
public class AccessPointScannerFactory {

    @Inject
    WindowsAccessPointScanner windowsAccessPointScanner;
    @Inject
    UnixAccessPointScanner unixAccessPointScanner;
    @Inject
    MacAccessPointScanner macAccessPointScanner;

    @Produces
    public AccessPointScanner createScanner() {
        String osName = System.getProperty("os.name").toLowerCase();
        if (osName.contains("win")) {
            return windowsAccessPointScanner;
        } else if (osName.contains("nix") || osName.contains("nux")) {
            return unixAccessPointScanner;
        } else if (osName.contains("mac")) {
            return macAccessPointScanner;
        } else {
            throw new UnsupportedOperationException("Unsupported operating system: " + osName);
        }
    }
}
