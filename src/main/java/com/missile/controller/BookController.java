package com.missile.controller;

import com.missile.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * @author Missile
 * @Date 2021-02-02-20:14
 */
@Controller
public class BookController {
    @Autowired
    private BookService bookService;
}
