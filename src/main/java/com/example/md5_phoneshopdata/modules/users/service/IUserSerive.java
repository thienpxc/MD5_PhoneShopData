package com.example.md5_phoneshopdata.modules.users.service;

import com.example.md5_phoneshopdata.modules.product.Product;
import com.example.md5_phoneshopdata.modules.users.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserSerive extends JpaRepository<Users, Integer> {
    Users findByEmail(String email);
   boolean existsByUserName(String userName);
    boolean existsByEmail(String email);
    boolean existsByPhone(String phone);

    default Users registerUser(Users user) {
        return save(user);
    }


}
