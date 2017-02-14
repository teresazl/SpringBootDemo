package com.teresazl.controller;

import com.teresazl.GirlProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by teresa on 2017/2/4.
 */
@RestController
public class HelloController {

//    @Value("${cupSize}")
//    private String cupSize;

    @Autowired
    private GirlProperties girlProperties;

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String sayHello() {
        return "Hello Spring Boot!";
    }

    // @RequestMapping(value = "/say/id", method = RequestMethod.GET)
    // 组合注解
    // @PostMapping(value = "say")
    @GetMapping(value = "say")
    public String say(@PathVariable int id,
                      @RequestParam(value = "age", required = false, defaultValue = "0") Integer age) {
        return "id: " + id + ", " + age;
    }

}
