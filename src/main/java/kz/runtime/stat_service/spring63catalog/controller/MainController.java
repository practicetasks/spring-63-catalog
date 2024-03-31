package kz.runtime.stat_service.spring63catalog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping
    public String mainPage() {
        return "index";
    }
}
