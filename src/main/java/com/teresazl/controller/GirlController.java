package com.teresazl.controller;

import com.teresazl.dao.GirlRepository;
import com.teresazl.entity.Girl;
import com.teresazl.service.GirlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by teresa on 2017/2/5.
 */
@RestController
public class GirlController {

    @Autowired
    private GirlRepository girlRepository;

    @Autowired
    private GirlService girlService;

    @GetMapping(value = "/girls")
    public List<Girl> girlList() {
        return girlRepository.findAll();
    }

    @PostMapping(value = "/girladd")
    public Girl addGirl(@RequestParam("cupSize") String cupSize,
                        @RequestParam("age") Integer age) {
        Girl girl = new Girl();
        girl.setCupSize(cupSize);
        girl.setAge(age);

        return girlRepository.save(girl);
    }

    @GetMapping(value = "/girl/{id}")
    public Girl findGril(@PathVariable("id") Integer id) {
        return girlRepository.findOne(id);
    }

    @PutMapping(value = "/girl/{id}")
    public Girl updateGril(@PathVariable("id") Integer id,
                           @RequestParam("cupSize") String cupSize,
                           @RequestParam("age") Integer age) {
//        Girl girl = girlRepository.findOne(id);
        Girl girl = new Girl();

        girl.setId(id);
        girl.setCupSize(cupSize);
        girl.setAge(age);

        return girlRepository.save(girl);
    }

    @DeleteMapping(value = "/girl/{id}")
    public void deleteGirl(@PathVariable("id") Integer id) {
        girlRepository.delete(id);
    }

    @GetMapping(value = "/girl/age/{age}")
    public List<Girl> findGirlByAge(@PathVariable("age") Integer age) {
        return girlRepository.findByAge(age);
    }

    @GetMapping(value = "/girl/two")
    public void insertTwo() {
        girlService.insertTwo();
    }

}
