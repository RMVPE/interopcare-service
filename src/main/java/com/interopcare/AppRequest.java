package com.interopcare;

public class AppRequest {
    private String name; // Matches {"name": "disco dancer"}

    // Default constructor is usually required by JSON deserializers (e.g., Jackson)
    public AppRequest() {
    }

    // Getters and Setters are ESSENTIAL for Jackson (Spring's default JSON library)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "AppRequest{" +
               "name='" + name + '\'' +
               '}';
    }
}
