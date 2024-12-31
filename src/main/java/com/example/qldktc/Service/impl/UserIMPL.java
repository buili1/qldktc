package com.example.qldktc.Service.impl;


import com.example.qldktc.Dto.LoginDTO;
import com.example.qldktc.Dto.UserDTO;
import com.example.qldktc.Jwt.JwtUtil;
import com.example.qldktc.Model.SinhVien;
import com.example.qldktc.Repo.RoleRepo;
import com.example.qldktc.Repo.UserRepo;
import com.example.qldktc.Service.UserService;
import com.example.qldktc.response.LoginResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserIMPL implements UserService {
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private RoleRepo roleRepo;
    private final JwtUtil jwtUtil;

    @Autowired
    public UserIMPL(JwtUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
    }

    @Override
    public String addUser(UserDTO userDTO) {

        SinhVien sinhVien = new SinhVien(userDTO.getMasv(), userDTO.getHoten(), userDTO.isGioitinh(),
                userDTO.getDiachi(), userDTO.getNgaysinh(), userDTO.getMalop(),
                userDTO.isDanghihoc(), this.passwordEncoder.encode(userDTO.getPassword()),
                userDTO.getCccd(), userDTO.getChuyennganh());
        //  Employee employee = new Employee(employeeDTO.getEmployeeid(), employeeDTO.getEmployeename(), employeeDTO.getEmail(), employeeDTO.getPassword());
        userRepo.save(sinhVien);
        return sinhVien.getHoten();
    }

    @Override
    public LoginResponse loginUser(LoginDTO loginDTO) {
        String msg = "";
        SinhVien sinhVien = userRepo.findByMasv(loginDTO.getMasv());
        if (sinhVien != null) {
            String password = loginDTO.getPassword();
            String encodedPassword = sinhVien.getPassword();
            Boolean isPwdRight = passwordEncoder.matches(password, encodedPassword);
            if (isPwdRight) {
                String token = jwtUtil.generateToken(sinhVien.getMasv(), sinhVien.getRole().getRole());
                return new LoginResponse("Login Success", true, token, sinhVien.getRole().getRole());
            } else {
                return new LoginResponse("Password Not Match", false, null, null);
            }
        } else {
            return new LoginResponse("Email not exists", false, null, null);
        }
    }
}
