package com.micromongodb.model;

import lombok.*;


@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Vehicle {


    public String id;
    public String model;
    public String userId;

    public Vehicle(String model, String userId) {
        this.model = model;
        this.userId = userId;
    }


}
