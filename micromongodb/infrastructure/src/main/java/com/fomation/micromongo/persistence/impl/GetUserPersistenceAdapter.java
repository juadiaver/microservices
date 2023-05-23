package com.fomation.micromongo.persistence.impl;




import com.fomation.micromongo.model.User;
import com.fomation.micromongo.usecase.GetUserUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class GetUserPersistenceAdapter implements GetUserUseCase {

    private final UserRepositoryMongo userRepositoryMongo;

    @Autowired
    public GetUserPersistenceAdapter(UserRepositoryMongo userRepositoryMongo) {
        this.userRepositoryMongo = userRepositoryMongo;
    }
    @Override
    public List<User> getUsers() {
        List<UserEntity> userDtoList = userRepositoryMongo.findAll();

        List<User> userList;

        userList = userDtoList.stream()
                .map( user -> new User(user.getId(), user.getName(),user.getAge())).toList();

        return userList;
    }
}
