package com.arep.parcial.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller("math")
public class MathController {
    @GetMapping("/binary-search")
    public String getMethodName(@RequestParam String param) {
        return new String();
    }
    
}
