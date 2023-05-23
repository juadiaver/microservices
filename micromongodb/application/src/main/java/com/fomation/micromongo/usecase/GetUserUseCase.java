package com.fomation.micromongo.usecase;


import com.fomation.micromongo.model.User;

import java.util.List;

public interface GetUserUseCase {

    List<User> getUsers ();
}
