package com.fomation.micromongo.persistence.impl;



import com.fomation.micromongo.dto.UserDTO;
import com.fomation.micromongo.model.User;

import com.fomation.micromongo.usecase.CreateUserUseCase;
import org.modelmapper.ModelMapper;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class CreateUserPersistenceAdapter implements CreateUserUseCase {

    private final UserRepositoryMongo createUserRepositoryMongo;

    private final ModelMapper modelMapper = new ModelMapper();

    private final KafkaTemplate<String, UserPlacedEvent> kafkaTemplate;

    public CreateUserPersistenceAdapter(UserRepositoryMongo createUserRepositoryMongo, KafkaTemplate<String, UserPlacedEvent> kafkaTemplate) {
        this.createUserRepositoryMongo = createUserRepositoryMongo;
        this.kafkaTemplate = kafkaTemplate;
    }
    @Override
    public User createdUser(User user) {
        UserEntity e = createUserRepositoryMongo.save(this.modelMapper.map(user, UserEntity.class));
        kafkaTemplate.send("notificationTopic",new UserPlacedEvent(e.getId()));
        return this.modelMapper.map(e,User.class);
    }

}
