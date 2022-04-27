package by.rom.springcourse.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/first")
public class FirstController {

    @GetMapping("/hello")
    public String helloPage(HttpServletRequest request) {
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");

        return "first/hello";
    }

    @GetMapping("/goodbye")
    public String goobyePage(@RequestParam(value = "name", required = false) String name,
                             @RequestParam(value = "surname", required = false) String surname) {
        return "first/goodbye";
    }

    @GetMapping("/calculator")
    public String calculator(@RequestParam(value = "a", required = false) int a,
                             @RequestParam(value = "b", required = false) int b,
                             @RequestParam(value = "b", required = false) String action,
                             Model model) {
        double result;
        switch (action) {
            case ("addition"):
                result = a + b;
                break;
            case ("subtraction"):
                result = a - b;
                break;
            case ("multiplication"):
                result = a * b;
                break;
            case ("division"):
                if (b != 0) {
                    result = (double) a / b;
                } else result = 0;
                break;
            default:
                result = -500;
                break;
        }

        model.addAttribute("calculator", action + " of " + a + " & " + b + " is: " + result);

        return "first/calculator";
    }
}
