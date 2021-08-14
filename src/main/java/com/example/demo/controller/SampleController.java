package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Person;
import com.example.demo.service.SampleService;

@RestController
public class SampleController {
    @Autowired
    SampleService service;

    /**
     * 一覧を返す
     * @return
     */
    @GetMapping("/")
    public List<Person> index() {
        return service.findAll();
    }

    /**
     * 追加して一覧を返す
     * @param person
     * @return
     */
    @GetMapping("/add/{name}/{age}")
    public List<Person> add(@ModelAttribute Person person) {

        service.save(person);
        return service.findAll();

    }
}