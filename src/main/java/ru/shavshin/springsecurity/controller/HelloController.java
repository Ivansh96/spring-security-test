package ru.shavshin.springsecurity.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import ru.shavshin.springsecurity.security.PersonDetails;
import ru.shavshin.springsecurity.service.AdminService;


@Controller
@RequiredArgsConstructor
public class HelloController {
    private final AdminService adminService;

    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

    @GetMapping("/showUserInfo")
    public String showUserInfo() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        PersonDetails personDetails = (PersonDetails) authentication.getPrincipal();

        System.out.println(personDetails.person());

        return "hello";
    }

    @GetMapping("/admin")
    public String adminPage() {
        adminService.doStuff();
        return "admin";
    }
}
