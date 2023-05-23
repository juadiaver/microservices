package com.micromongodb.persistence;


import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document( collection = "vehicles")
public class VehicleEntity {


    public String id;
    public String model;
    public String userId;

    public VehicleEntity(String model, String userId) {
        this.model = model;
        this.userId = userId;
    }


}
