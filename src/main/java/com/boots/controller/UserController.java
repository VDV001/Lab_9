package com.boots.controller;

import com.boots.entity.TablesReaderBook.Book;
import com.boots.service.BookService;
import com.boots.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {
    @Autowired
    private BookService bookService;
    @GetMapping("/tableBooks")
    public String tableBooks(Model model) {
        model.addAttribute("allBooks", bookService.allBooks());
        return "tableBooks";
    }
}
