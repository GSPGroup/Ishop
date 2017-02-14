package ua.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HTTPErrorHandler{

    String path = "/error";

    @RequestMapping(value="/404")
    public String error404(){
     System.out.println("custom error handler");
     return "404";
    }
    }