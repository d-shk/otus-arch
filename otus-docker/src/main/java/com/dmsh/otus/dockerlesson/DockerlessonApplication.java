package com.dmsh.otus.dockerlesson;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MimeType;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class DockerlessonApplication {

    public static void main(String[] args) {
        SpringApplication.run(DockerlessonApplication.class, args);
    }

    @RestController
    class HealthCheck {

        @GetMapping(value = "/health", produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
        public ResponseEntity health() {
            return ResponseEntity.ok().body("{\"Status\": \"OK\"}");
        }

        @GetMapping(value = "/", produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
        public ResponseEntity hellootus() {
            String hostName = System.getenv("HOSTNAME");
            return ResponseEntity.ok().body("{\"Message\": \""+hostName+"\"}");
        }
    }

}
