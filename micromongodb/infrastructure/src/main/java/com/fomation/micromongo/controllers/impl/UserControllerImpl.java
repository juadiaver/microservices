package com.fomation.micromongo.controllers.impl;


import com.fomation.micromongo.controllers.UserController;
import com.fomation.micromongo.dto.UserDTO;
import com.fomation.micromongo.model.User;
import com.fomation.micromongo.persistence.impl.CreateUserPersistenceAdapter;
import com.fomation.micromongo.persistence.impl.GetUserPersistenceAdapter;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserControllerImpl implements UserController {

    private final CreateUserPersistenceAdapter createUserPersistenceAdapter;
    private final GetUserPersistenceAdapter getUserPersistenceAdapter;

    private final ModelMapper modelMapper = new ModelMapper();

    public UserControllerImpl(CreateUserPersistenceAdapter createUserPersistenceAdapter, GetUserPersistenceAdapter getUserPersistenceAdapter) {
        this.createUserPersistenceAdapter = createUserPersistenceAdapter;
        this.getUserPersistenceAdapter = getUserPersistenceAdapter;
    }

    @Override
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO userDTO) {
        User createdUser = createUserPersistenceAdapter.createdUser(this.modelMapper.map(userDTO, User.class));
        return new ResponseEntity<>(this.modelMapper.map(createdUser, UserDTO.class), HttpStatus.CREATED);
    }

    @Override
    @RequestMapping(value = "/get", method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<UserDTO>> getUsers() {
        return new ResponseEntity<>(getUserPersistenceAdapter.getUsers().stream().map(user -> this.modelMapper.map(user,UserDTO.class)).toList(), HttpStatus.OK);
    }


}
