package org.shellymadrid.utility.service.implementation;

import org.shellymadrid.utility.service.GreetingServiceInterface;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class GreetingService implements GreetingServiceInterface {

    @Override
    public String greet(String name) {
        return "Hello, " + name + "!";
    }
}
