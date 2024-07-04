package com.example.md5_phoneshopdata.modules.users.login;


import com.example.md5_phoneshopdata.modules.users.Users;
import com.example.md5_phoneshopdata.modules.users.login.Error;
import com.example.md5_phoneshopdata.modules.users.login.dto.CreateRespone;
import com.example.md5_phoneshopdata.modules.users.login.dto.UserRegisterdto;
import com.example.md5_phoneshopdata.modules.users.login.dto.login.LoginReqDto;
import com.example.md5_phoneshopdata.modules.users.login.dto.login.LoginResDto;
import com.example.md5_phoneshopdata.modules.users.login.dto.login.VerifyDTO;
import com.example.md5_phoneshopdata.modules.users.login.dto.login.VerifyReqDTO;
import com.example.md5_phoneshopdata.modules.users.login.mail.EmailTemplate;
import com.example.md5_phoneshopdata.modules.users.login.mail.MailService;
import com.example.md5_phoneshopdata.modules.users.login.mail.Option;
import com.example.md5_phoneshopdata.modules.users.login.service.IUserSerive;
import com.example.md5_phoneshopdata.modules.users.login.service.UserService;
import com.example.md5_phoneshopdata.util.jwt.JwtBuilder;
import com.example.md5_phoneshopdata.util.jwt.dto.EmailConfirmDto;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@Controller
@RequestMapping("/api")
@CrossOrigin("*")
public class UserCotroller {

    @Autowired
    private IUserSerive iuserSerive;

    @Autowired
    private UserService userService;
    @Autowired
    private MailService mailService;



    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody UserRegisterdto userRegisterDto) {

        if (iuserSerive.existsByUserName(userRegisterDto.getUserName())) {
            return ResponseEntity
                    .badRequest()
                    .body(new Error("Tên người dùng đã được sử dụng!"));
        }
        if (iuserSerive.existsByEmail(userRegisterDto.getEmail())) {
            return ResponseEntity
                    .badRequest()
                    .body(new Error(" Email đã được sử dụng!"));
        }

        if (iuserSerive.existsByPhone(userRegisterDto.getPhone())) {
            return ResponseEntity
                    .badRequest()
                    .body(new Error("Số điện thoại đã được sử dụng!"));
        }


        String hashedPassword = BCrypt.hashpw(userRegisterDto.getPassword(), BCrypt.gensalt());
        userRegisterDto.setPassword(hashedPassword);

        Users user = userService.convertToUser(userRegisterDto);
        System.out.println("user"+user);
        CreateRespone result = new CreateRespone();

        result.setData(user);
        result.setMessage("Đăng ký thành công ! Vui lòng kiểm tra email để xác thực tài khoản");
        if(result.getData() != null) {
//            String userName = result.getData().getUserName();
            String userEmail = result.getData().getEmail();
            ArrayList<String> emails = new ArrayList<>();
            emails.add(userEmail);
            String token;
            try {
                token = JwtBuilder.createTokenForConfirmEmail(new EmailConfirmDto(result.getData().getEmail(), result.getData().getId()));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
                // Xử lý lỗi tại đây, ví dụ: ghi log, trả về lỗi cho người dùng,...
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error while creating token");
            }

            String verificationLink = "http://localhost:1234/api/user/status-email?token=" + token;
            String emailContent = EmailTemplate.generateEmailContent( userEmail, verificationLink);
            // Add more emails to the list if needed
            mailService.sendMailHtml(new Option("Xác thực tài khoản của bạn tại Cellphones", emailContent, emails));
        }


        user = iuserSerive.registerUser(user);
        result.setData(user);
        return ResponseEntity.ok(result);
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResDto> loginUser(@RequestBody LoginReqDto body) throws IllegalAccessException {

        System.out.println("body" + body);
        Users user = userService.findByLoginId(body.getLoginId());
        if(user == null) {
            System.out.println("Tài khoản không tồn tại"+ user);
            return new ResponseEntity<LoginResDto>(new LoginResDto("Tài khoản không tồn tại", null), HttpStatus.BAD_REQUEST);
        }else {
            if(!BCrypt.checkpw(body.getPassword(), user.getPassword())) {
                return new ResponseEntity<LoginResDto>(new LoginResDto("Mật khẩu sai", null), HttpStatus.BAD_REQUEST);
            }else {
                if(!user.isStatus()) {
                    return new ResponseEntity<LoginResDto>(new LoginResDto("Tài khoản chưa được kích hoạt", null), HttpStatus.BAD_REQUEST);
                }
                System.out.println("Tài khoản không tồn tại"+ user);
                return new ResponseEntity<LoginResDto>(new LoginResDto("Đăng nhập thành công", JwtBuilder.createTokenUser(user)), HttpStatus.OK);
            }
        }
    }

    @PostMapping("/user/verify")
    public ResponseEntity<VerifyDTO> verifyUser(@RequestBody VerifyReqDTO body) {
        Users user = JwtBuilder.verifyTokenUser(body.getToken());
        System.out.println("user " + user);
        if(user == null) {
            return new ResponseEntity<VerifyDTO>(new VerifyDTO("Token không hợp lệ", null), HttpStatus.BAD_REQUEST);
        }else {
            return new ResponseEntity<VerifyDTO>(new VerifyDTO("Token hợp lệ", user), HttpStatus.OK);
        }
    }



    @GetMapping("/user/status-email")
    public String confirmEmail(@RequestParam("token") String token) throws IllegalAccessException {
        EmailConfirmDto data = JwtBuilder.verifyTokenForEmailConfirm(token);
        Users oldData = userService.findById(data.getId());
        oldData.setStatus(true);
        Users newData = userService.update(oldData);
        if(newData != null) {
            return "email_dxt.html";
        }else {
            return "email_txl.html";
        }
    }

   @GetMapping("/user")
public ResponseEntity<?> getAllUser(){
    return ResponseEntity.ok(iuserSerive.findAllByOrderByIdDesc());
}

    @PostMapping("/user/block/{id}")
public ResponseEntity<?> toggleUserStatus(@PathVariable Integer id){
    Optional<Users> userOptional = iuserSerive.findById(id);
    if (userOptional.isPresent()) {
        Users user = userOptional.get();
        user.setStatus(!user.isStatus()); // Toggle status
        iuserSerive.save(user); // Save the user with the new status
        return ResponseEntity.ok("User status has been toggled successfully.");
    } else {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found.");
    }
}
}
