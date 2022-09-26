package ru.voldemar.course.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Objects;

@Controller
@RequestMapping("/third")
public class CalculatorController {
    @GetMapping("/calculator")
    public String calculator(@RequestParam(value = "a",required = false) Integer a,
                             @RequestParam(value = "b", required = false) Integer b,
                             @RequestParam(value = "action", required = false) String action,
                             Model model){
        double result = choose(a, b, action);
        model.addAttribute("result","Result:= "+ result);
        return "third/calculator";
    }

    public double choose(Integer a, Integer b, String action){
        double d;
        if(action != null){
            switch (Objects.requireNonNull(action)){
                case "multiplication": return a*b;
                case "addition": return a+b;
                case "subtraction": return a-b;
                case "division": d = (double)a/(double)b; return d;
                default: return 0;
            }
        }
        else return 0;
    }
}
