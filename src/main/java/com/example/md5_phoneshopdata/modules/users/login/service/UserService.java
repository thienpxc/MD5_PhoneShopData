package com.example.md5_phoneshopdata.modules.users.login.service;

import com.example.md5_phoneshopdata.modules.users.Users;
import com.example.md5_phoneshopdata.modules.users.login.dto.UserRegisterdto;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService{

    @Autowired
    IUserSerive iUserSerive;
    public Users convertToUser(UserRegisterdto userRegisterDto) {
        Users user = new Users();
        BeanUtils.copyProperties(userRegisterDto, user);


        Users savedUser = iUserSerive.save(user);
        user.setDate(savedUser.getDate());

        return savedUser;
    }
    public Users findByLoginId(String userId) {
        try {
            Users users = iUserSerive.findByLoginId(userId);
            System.out.println("userssssssssssssssssssssssssssssssssssssss"+users);
            return users;
        } catch (Exception e) {
            return null;
        }
    }
    public Users update(Users data) {
        try {
            Users user = iUserSerive.save(data);

            return user;
        } catch (Exception e) {
            return null;
        }
    }
    public Users findById(int userId) {
        try {
            Optional<Users> userF = iUserSerive.findById(userId);
            if (userF.isPresent()) {
                return userF.get();
            } else {
                return null;
            }
        } catch (Exception e) {
            return null;
        }
    }

}

