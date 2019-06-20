package com.enderstudy.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.ResponseBody;

@Slf4j
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
    public String welcome(Model model) {
        model.addAttribute("user", "Tom");
        log.info("model={}", model);

        return "welcome";
    }

    @ModelAttribute("welcomeMessage")
    public String welcomeMessage() {
        log.info("welcomeMessage() called");
        return "Hello and all the things";
    }
}
