package edu.codeup.codeupspringblog.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MathController {
    @GetMapping("/add/{num1}/and/{num2}")
    @ResponseBody
    public String addNumbers(@PathVariable int num1, @PathVariable int num2){
        int sum = num1 + num2;
        return Integer.toString(sum);

    }
    @GetMapping("/subtract/{num1}/from{num2}")
    @ResponseBody
    public String subtractNumbers(@PathVariable int num1, @PathVariable int num2){
        int total = num2 - num1;
        return Integer.toString(total);
    }
    @GetMapping("/multiply/{num1}/and/{num2}")
    @ResponseBody
    public String multiplyNumbers(@PathVariable int num1, @PathVariable int num2){
        int total = num1 * num2;
        return Integer.toString(total);
    }
    @GetMapping("/divide/{num1}/from{num2}")
    @ResponseBody
    public String divideNumbers(@PathVariable double num1, @PathVariable double num2){
       double total = num1 / num2;
        return String.format("%s/ %s = %s", num1, num2, total);
    }

}
