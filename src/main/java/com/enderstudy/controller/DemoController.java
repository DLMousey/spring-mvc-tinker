package com.enderstudy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class DemoController {

    @ResponseBody
    @GetMapping("/hello")
    public String hello() {
        return "Hello";
    }

    // Leading slash will be added automatically, ResponseBody annotation not required.
    // View should be automatically resolved due to file name matching method name
    @GetMapping("welcome")
    public String welcome() {
        return "welcome";
    }
}
