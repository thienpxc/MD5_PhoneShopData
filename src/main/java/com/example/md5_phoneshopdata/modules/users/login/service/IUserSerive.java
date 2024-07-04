package com.example.md5_phoneshopdata.modules.users.login.service;

import com.example.md5_phoneshopdata.modules.product.Product;
import com.example.md5_phoneshopdata.modules.users.Users;
import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IUserSerive extends JpaRepository<Users, Integer> {
    Users findByEmail(String email);
   boolean existsByUserName(String userName);
    boolean existsByEmail(String email);
    boolean existsByPhone(String phone);


    default Users registerUser(Users user) {
        return save(user);
    }

    @Query(value = "SELECT * FROM users WHERE users.userName = :loginId OR (users.email = :loginId AND users.status = true)", nativeQuery = true)
    Users findByLoginId(@Param("loginId") String loginId);

    //delete user
    void deleteById(Integer id);

    // Trong IUserSerive
    List<Users> findAllByOrderByIdDesc();


}
