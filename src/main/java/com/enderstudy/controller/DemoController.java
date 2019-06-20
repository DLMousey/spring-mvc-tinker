package com.enderstudy.controller;

import com.enderstudy.service.DemoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.ResponseBody;

@Slf4j
@Controller
public class DemoController {

    private final DemoService demoService;

    @Autowired
    public DemoController(DemoService demoService) {
        this.demoService = demoService;
    }

    @ResponseBody
    @GetMapping("/hello")
    public String hello() {
        return demoService.getHelloMessage();
    }

    // Leading slash will be added automatically, ResponseBody annotation not required.
    // View should be automatically resolved due to file name matching method name
    @GetMapping("welcome")
    public String welcome(Model model) {
        model.addAttribute("helloMessage", demoService.getHelloMessage("Tom"));
        log.info("model={}", model);

        return "welcome";
    }

    @ModelAttribute("welcomeMessage")
    public String welcomeMessage() {
        log.info("welcomeMessage() called");
        return demoService.getHelloMessage();
    }
}
