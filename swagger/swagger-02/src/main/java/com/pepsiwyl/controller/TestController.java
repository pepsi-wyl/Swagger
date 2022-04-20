package com.pepsiwyl.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author by pepsi-wyl
 * @date 2022-04-19 21:00
 */

@RestController
public class TestController {
    @GetMapping(value = "/hello")
    public String hello() {
        return "hello";
    }
}
