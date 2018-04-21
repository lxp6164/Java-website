package com.lxp.LittleMusic;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.HashMap;
import java.util.Map;

@RestController
public class JsonController {

    @GetMapping("/json")
    public Map<String, Object> test(){
        Map m = new HashMap<>();
        m.put("t", "d");
        return m;
    }
}
