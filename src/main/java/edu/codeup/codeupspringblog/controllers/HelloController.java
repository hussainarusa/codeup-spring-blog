package edu.codeup.codeupspringblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller

public class HelloController {

//    @GetMapping("/hello/world")
//    @ResponseBody
//    public String HelloWorld(){
//        return "hello, world!";
//    }
//    @GetMapping("/hello/${name}")
//    @ResponseBody
//    public String helloName(@PathVariable String name){
//        return String.format("hello, %s", name);
//    }


    @GetMapping("/hello/{name}")
    public String sayHello(@PathVariable String name, Model model){
        model.addAttribute("name", name);
        return "hello";
    }
}
