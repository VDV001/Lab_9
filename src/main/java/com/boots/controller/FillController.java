package com.boots.controller;

import com.boots.entity.TablesUserRole.User;
import com.boots.service.FillWebService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class FillController {
    @Autowired
    private FillWebService fillWebService;

    @GetMapping("/registration")
    public String fill(Model model) {
        model.addAttribute("userForm", new User());
        fillWebService.FillTables();

        return "registration";
    }
}
