package com.example.md5_phoneshopdata.util.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.example.md5_phoneshopdata.modules.users.Users;

import com.example.md5_phoneshopdata.util.jwt.dto.EmailConfirmDto;

import java.lang.reflect.Field;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class JwtBuilder {
    private static String secretKey = "ThienPxc";
    public static String createTokenForConfirmEmail(EmailConfirmDto data) throws IllegalAccessException {
        JWTCreator.Builder builder = JWT.create().withIssuer("auth0");

        Field[] fields = EmailConfirmDto.class.getDeclaredFields();
        for (Field field : fields) {

            field.setAccessible(true);
            Object value = field.get(data);
            if (value != null) {
                if (field.getName().equals("id")) {
                    builder.withClaim("id", (Integer) value);
                } else {
                    builder.withClaim(field.getName(), value.toString());
                }
            }
        }
        return builder.sign(Algorithm.HMAC256(secretKey));
    }
    public static EmailConfirmDto verifyTokenForEmailConfirm(String token) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(secretKey);
            DecodedJWT jwt = JWT.require(algorithm)
                    .withIssuer("auth0")
                    .build()
                    .verify(token);

            String email = jwt.getClaim("email").asString();
            System.out.println(email+"email");


            Claim idClaim = jwt.getClaim("id");
            if (idClaim.isNull()) {
                throw new JWTVerificationException("Missing 'id' claim in JWT");
            }
            Integer id = idClaim.asInt();
            if (id == null) {
                throw new JWTVerificationException("Invalid 'id' claim in JWT");
            }
            EmailConfirmDto emailConfirm = new EmailConfirmDto(email, id);

            return emailConfirm;
        } catch (JWTVerificationException exception){
            return null;
        }
    }
    public static String createTokenUser(Users data) throws IllegalAccessException {
        JWTCreator.Builder builder = JWT.create().withIssuer("auth0");
        Field[] fields = Users.class.getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            Object value = field.get(data);
            if (value != null) {
                builder.withClaim(field.getName(), value.toString());
            }
        }

        return builder.sign(Algorithm.HMAC256(secretKey));
    }
    public static Users verifyTokenUser(String token) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(secretKey);
            DecodedJWT jwt = JWT.require(algorithm)
                    .withIssuer("auth0")
                    .build()
                    .verify(token);

            String email = jwt.getClaim("email").asString();
            Integer id = Integer.parseInt(jwt.getClaim("id").asString());
            Boolean role = Boolean.valueOf(jwt.getClaim("role").asString());
            Boolean status = Boolean.valueOf(jwt.getClaim("status").asString());
            String userName = jwt.getClaim("userName").asString();
            String password = jwt.getClaim("password").asString();
            String phone = jwt.getClaim("phone").asString();
            String address = jwt.getClaim("address").asString();
            String dateString = jwt.getClaim("date").asString();
            String updateDate = jwt.getClaim("updateDate").asString();
            return new Users(id, userName, email, password, phone, address, dateString, updateDate, status, role);
        } catch (JWTVerificationException exception){
            return null;
        }
    }
}
