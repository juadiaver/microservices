package com.fomation.micromongo.persistence.impl;



import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepositoryMongo extends MongoRepository<UserEntity,String> {
}
