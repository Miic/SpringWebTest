package me.Miic.SpringWebTest.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

@RestController
public class HelloWorldController {

    @RequestMapping("/hello")
    public String sayHello(@RequestParam(value = "name") String name) {
        return "Hello " + name + "!";
    }

    @RequestMapping("/byteify")
    public String byteify(@RequestParam(value = "input") String input) {
        return Arrays.toString(input.getBytes());
    }

}
