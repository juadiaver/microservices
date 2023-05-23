package com.fomation.micromongo.usecase;


import com.fomation.micromongo.model.User;

public interface CreateUserUseCase {

    User createdUser(User user);

}
