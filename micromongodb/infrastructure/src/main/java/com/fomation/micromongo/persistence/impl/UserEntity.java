package com.fomation.micromongo.persistence.impl;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document( collection = "users")
public class UserEntity {

    @Id
    public String id;
    public String name;
    public int age;


    public UserEntity(String name, int age) {
        this.name = name;
        this.age = age;
    }
}