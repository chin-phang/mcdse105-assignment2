package org.mcdse105.assignment2.controller;

import lombok.RequiredArgsConstructor;
import org.mcdse105.assignment2.entity.User;
import org.mcdse105.assignment2.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class CommonController {

    private final UserService userService;

    @GetMapping("/")
    public String getHomePage() {
        return "index";
    }

    @GetMapping("/about")
    public String getAboutPage() {
        return "about";
    }

    @GetMapping("/contact")
    public String getContactPage() {
        return "contact";
    }

    @GetMapping("/register")
    public String getRegistrationPage() {
        return "register";
    }

    @PostMapping("/register")
    public String registerNewUser(Model model, @ModelAttribute("user") User user, @RequestParam String cpassword) {

        if(!userService.verifyEmail(user.getEmail())) {

            if(user.getPassword().matches(cpassword)) {
                userService.registerNewUser(user);
                return "index";

            } else {
                model.addAttribute("errMsg", "Password not match!");
                return "register";
            }

        } else {
            model.addAttribute("errMsg", "User/email already exists!");
            return "register";
        }
    }

    @GetMapping("/login")
    public String getLoginPage() {
        return "login";
    }
}
