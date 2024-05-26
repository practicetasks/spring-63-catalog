package kz.runtime.stat_service.spring63catalog.controller;

import kz.runtime.stat_service.spring63catalog.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class MainController {

    private final UserService userService;

    @GetMapping
    public String mainPage(Model model) {
        model.addAttribute("user", userService.getUser());
        return "index";
    }
}
