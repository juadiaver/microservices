package com.fomation.micromongo.persistence.impl;



import com.fomation.micromongo.model.User;

import com.fomation.micromongo.usecase.CreateUserUseCase;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateUserPersistenceAdapter implements CreateUserUseCase {

    private final UserRepositoryMongo createUserRepositoryMongo;

    private final ModelMapper modelMapper = new ModelMapper();

    public CreateUserPersistenceAdapter(UserRepositoryMongo createUserRepositoryMongo) {
        this.createUserRepositoryMongo = createUserRepositoryMongo;
    }
    @Override
    public User createdUser(User user) {
        UserEntity e = createUserRepositoryMongo.save(this.modelMapper.map(user, UserEntity.class));
        return this.modelMapper.map(e,User.class);
    }

}
