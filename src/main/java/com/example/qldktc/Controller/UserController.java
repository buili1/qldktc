package com.example.qldktc.Controller;


import com.example.qldktc.Dto.LoginDTO;
import com.example.qldktc.Dto.UserDTO;
import com.example.qldktc.Jwt.JwtUtil;
import com.example.qldktc.Service.UserService;
import com.example.qldktc.response.LoginResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("api/v1/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping(path = "/save")
    public String saveEmployee(@RequestBody UserDTO userDTO){
        String id = userService.addUser(userDTO);
        return id;
    }

//    @PostMapping(path = "/login")
//    public ResponseEntity<?> loginEmployee(@RequestBody LoginDTO loginDTO){
//        LoginResponse loginResponse = userService.loginUser(loginDTO);
//        return ResponseEntity.ok(loginResponse);
//    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginDTO loginDTO) {
        LoginResponse response = userService.loginUser(loginDTO);
        if (response.getStatus()) {
            JwtUtil jwtUtil = new JwtUtil();
            String token = jwtUtil.generateToken(loginDTO.getMasv(), response.getRole());
            return ResponseEntity.ok(Map.of(
                    "message", "Login Success",
                    "token", token,
                    "role", response.getRole()
            ));
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(Map.of(
                "message", response.getMessage()
        ));
    }



}
