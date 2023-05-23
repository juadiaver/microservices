package com.micromongodb.persistence;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface VehicleRepositoryMongo extends MongoRepository<VehicleEntity,String> {
}
