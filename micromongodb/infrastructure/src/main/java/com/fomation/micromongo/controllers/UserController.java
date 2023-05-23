package com.fomation.micromongo.controllers;


import com.fomation.micromongo.dto.UserDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface UserController {

    ResponseEntity<UserDTO> createUser(@RequestBody UserDTO userDTO);

    ResponseEntity<List<UserDTO>> getUsers();

}
