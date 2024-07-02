package com.example.md5_phoneshopdata.modules.users.service;

import com.example.md5_phoneshopdata.modules.users.Users;
import com.example.md5_phoneshopdata.modules.users.dto.UserRegisterdto;
import org.springframework.stereotype.Service;

@Service
public class UserService{
    public Users convertToUser(UserRegisterdto userRegisterDto) {
        Users user = new Users();
        user.setUserName(userRegisterDto.getUserName());
        user.setEmail(userRegisterDto.getEmail());
        user.setPhone(userRegisterDto.getPhone());
        user.setPassword(userRegisterDto.getPassword()); // Remember to hash the password before saving
        user.setDate(userRegisterDto.getDate().toString()); // Convert Date to String
        user.setStatus(true); // Set default status
        // Set other fields as needed
        return user;
    }
}

