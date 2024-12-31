package com.example.qldktc.Service;


import com.example.qldktc.Dto.LoginDTO;
import com.example.qldktc.Dto.UserDTO;
import com.example.qldktc.response.LoginResponse;

public interface UserService  {

     String addUser(UserDTO userDTO);

     LoginResponse loginUser(LoginDTO loginDTO);
}