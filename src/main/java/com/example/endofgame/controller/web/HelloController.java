package com.example.endofgame.controller.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@Slf4j
public class HelloController {

    // /first?login=maniek&password=12345
    // parameters are put after ? char
    @GetMapping("/first")
    public String hello(@RequestParam(value = "login", required = false) String login,
                        @RequestParam(value = "password", defaultValue = "not-provided") String password,
                        Model valuesForTemplate) {
        log.info("login: [{}], password: [{}]", login, password);

        valuesForTemplate.addAttribute("pass", password);
        valuesForTemplate.addAttribute("user", login);

        return "hello";
    }
}
