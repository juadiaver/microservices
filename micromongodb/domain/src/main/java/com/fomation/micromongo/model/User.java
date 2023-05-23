package com.fomation.micromongo.model;


import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {


    public String id;
    public String name;
    public int age;


    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }
}