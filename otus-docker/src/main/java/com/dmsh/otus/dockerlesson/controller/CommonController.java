package com.dmsh.otus.dockerlesson.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class CommonController {
    @GetMapping(value = "/health", produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> health() {
        return ResponseEntity.ok().body("{\"Status\": \"OK\"}");
    }

    @GetMapping(value = "/", produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> hostname() {
        String hostName = System.getenv("HOSTNAME");
        return ResponseEntity.ok().body("{\"Message\": \""+hostName+"\"}");
    }
}
