package com.example.pineappleappback.response;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

//This class generates a response to send flags and states to each HTTP request.
public class ResponseHandler {
    public static ResponseEntity<Object> generateResponse(String message, HttpStatus status, Object responseObj,
            Boolean error) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("message", message);
        map.put("status", status.value());
        map.put("data", responseObj);
        map.put("error", error);

        return new ResponseEntity<Object>(map, status);
    }
}