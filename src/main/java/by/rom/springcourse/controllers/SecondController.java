package by.rom.springcourse.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SecondController {
    @GetMapping("/exit")
    public String exit(@RequestParam(value = "name", required = false) String name,
                       @RequestParam(value = "surname", required = false) String surname,
                       Model model) {
        model.addAttribute("message", "Goodbye " + name + " " + surname);

        return "second/exit";
    }
}
