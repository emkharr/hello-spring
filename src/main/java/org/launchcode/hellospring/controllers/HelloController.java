package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
//@RequestMapping("hello")
public class HelloController {
//each related piece of an app will have a specific controller and live within a certain word like this one in hello

    // handle requests of the form /hello?name=LaunchCode
    //lives at /hello
    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST}, value = "hello")
    public String hello(@RequestParam String name, Model model){
        String helloName = "Hello, " + name + "!";
        model.addAttribute("greeting", helloName);
        return "hello";
    }

    @GetMapping("hello/{name}")
    public String helloAgain(@PathVariable String name, Model model){
        model.addAttribute("greeting","Hello, " + name + "!");
        return "hello";
    }

    @GetMapping("form")
    public String helloForm(){
        return "form";
    }

    @GetMapping("hello-names")
    public String helloNames(Model model) {
        List<String> names = new ArrayList<>();
        names.add("Emily");
        names.add("Justin");
        names.add("Tori");
        model.addAttribute("namesList", names);
        return "list-of-names";
    }
}
