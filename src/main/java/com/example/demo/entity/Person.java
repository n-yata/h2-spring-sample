package com.example.demo.entity;

import lombok.Getter;
import lombok.Setter;

public class Person {
    // AUTO_INCREMENTでIDを付与
    @Setter
    @Getter
    private Long id;

    @Setter
    @Getter
    private String name;

    @Setter
    @Getter
    private Long age;

    @Override
    public String toString() {
        return "Person [id=" + id + ", name=" + name + ", age=" + age + "]";
    }

}
