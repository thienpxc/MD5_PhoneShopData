package com.example.md5_phoneshopdata.modules.users;


import com.example.md5_phoneshopdata.modules.users.dto.UserRegisterdto;
import com.example.md5_phoneshopdata.modules.users.service.IUserSerive;
import com.example.md5_phoneshopdata.modules.users.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class UserCotroller {

    @Autowired
    private IUserSerive iuserSerive;

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody UserRegisterdto userRegisterDto) {

        if (iuserSerive.existsByUserName(userRegisterDto.getUserName())) {
            return ResponseEntity
                    .badRequest()
                    .body(new Error("Error: Username is already taken!"));
        }
        if (iuserSerive.existsByEmail(userRegisterDto.getEmail())) {
            return ResponseEntity
                    .badRequest()
                    .body(new Error("Error: Email is already in use!"));
        }

        if (iuserSerive.existsByPhone(userRegisterDto.getPhone())) {
            return ResponseEntity
                    .badRequest()
                    .body(new Error("Error: Phone number is already in use!"));
        }
//        CreateRespone result  = userModel.create(registerReqDTO);
//        if(result.getData() != null) {
//            mailService.sendMail(new SingleOption("tieucamieu@gmail.com", "ok", result.getData().getEmail()));
//        }

        Users user = userService.convertToUser(userRegisterDto);
        user = iuserSerive.registerUser(user);
        return ResponseEntity.ok(user);
    }
}
