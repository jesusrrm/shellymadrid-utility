package com.shellymadrid.utility.api;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

import java.util.List;
import java.util.stream.Collectors;

import com.shellymadrid.utility.model.AccessPoint;
import com.shellymadrid.utility.service.factory.AccessPointScannerFactory;

@Path("/access-point")
public class AccessPointApi {
    @Inject
    AccessPointScannerFactory accessPointScannerFactory;

    @GET
    @Path("/search")
    public List<AccessPoint> search() {
        return accessPointScannerFactory.createScanner().scan().stream()
                .filter(ap -> ap.getSsid().toLowerCase().contains("shelly"))
                .collect(Collectors.toList());
    }

}
