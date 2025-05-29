package com.interopcare;

import java.util.Collections;
import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
@RestController  // Added to enable controller capabilities
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000")
public class App 
{
public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    @GetMapping("/hello")
    public String sayHello() {
        return ("Hello from InteropCare Services from api/hello Endpoint!!");
    }

    // @PostMapping("/data")  // Full path will be /api/data
    // public ResponseEntity<String> processData(@RequestBody Map<String, String> payload) {
    //     String name = payload.get("name");
    //     System.out.println("value of passed input = " + name);
    //     return ResponseEntity.ok("Received by InteropCare Service: " + name);
    // }
    @PostMapping("/data") // Your endpoint
    public ResponseEntity<Map<String, String>> receiveData(@RequestBody AppRequest request) {
        if (request != null && request.getName() != null) { // Assuming your POJO now has a 'name' field
            String receivedName = request.getName();
            System.out.println("Received name: " + receivedName);

            // Return a JSON object with a success message
            // This will be {"message": "Received by InteropCare Service: disco dancer"}
            return ResponseEntity.ok(Collections.singletonMap("message", "Received by InteropCare Service: " + receivedName));

        } else {
            System.out.println("Received a null request object or null name.");
            // Return a JSON error message with a 400 status
            return ResponseEntity.badRequest().body(Collections.singletonMap("error", "Data was null or missing 'name'"));
        }
    }
}
