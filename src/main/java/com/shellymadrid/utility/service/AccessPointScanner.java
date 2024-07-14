package com.shellymadrid.utility.service;

import java.util.List;

import com.shellymadrid.utility.model.AccessPoint;

public interface AccessPointScanner {
    List<AccessPoint> scan();
}