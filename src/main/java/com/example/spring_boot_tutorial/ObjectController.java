package com.example.spring_boot_tutorial;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RestController
public class ObjectController {
    @GetMapping("/api/object")
    @ResponseBody
    public Object getObject() {
        Map<String, Object> object = new HashMap<>();
        object.put("key1", "value1");
        object.put("key2", "value2");
        return object;
    }
}
