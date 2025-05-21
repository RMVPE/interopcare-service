package com.interopcare;

import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
@RestController  // Added to enable controller capabilities
@RequestMapping("/api")
public class App 
{
public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    @GetMapping("/hello")
    public String sayHello() {
        return ("Hello from InteropCare Services from api/hello Endpoint!!");
    }

    @PostMapping("/data")  // Full path will be /api/data
    public ResponseEntity<String> processData(@RequestBody Map<String, String> payload) {
        String name = payload.get("name");
        return ResponseEntity.ok("Received by InteropCare Service: " + name);
    }
}
