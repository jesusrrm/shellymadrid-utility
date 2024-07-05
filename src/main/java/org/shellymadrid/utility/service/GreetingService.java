package org.shellymadrid.utility.service;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class GreetingService implements GreetingServiceInterface {

    @Override
    public String greet(String name) {
        return "Hello, " + name + "!";
    }
}
