package com.kodilla.tasks.controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import java.util.Map;

@Controller
public class StaticWebPageController {

    @RequestMapping("/")
    public String index(Map<String, Object> model){
        model.put("variable", "My themeleaf variable");
        model.put("one", 1);
        model.put("two", 2);
        return "index";
    }
}
