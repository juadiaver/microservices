package com.fomation.micromongo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Data
@Setter
@Getter
public class UserDTO {

    @JsonProperty("id")
    public String id;

    @JsonProperty("name")
    public String name;

    @JsonProperty("age")
    public int age;

    public UserDTO(String id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public UserDTO(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public UserDTO() {
    }
}
