package com.example.md5_phoneshopdata.modules.users.login.mail;

public class EmailTemplate {
    private static final String HTML_TEMPLATE =
            "<html>" +
                    "<head>" +
                    "<meta charset='utf-8'>" +
                    "<meta name='viewport' content='width=device-width, initial-scale=1.0'>" +
                    "</head>" +
                    "<body style='font-family: Arial, sans-serif; margin: 0; padding: 0;'>" +
                    "<div style='max-width: 600px; margin: 0 auto; padding: 20px;'>" +
                    "<div style='text-align: center; margin-bottom: 20px;'>" +
                    "<img src='https://cdn2.cellphones.com.vn/insecure/rs:fill:0:80/q:90/plain/https://cellphones.com.vn/media/wysiwyg/chibi2.png' alt='Biihappy' style='max-width: 100%%; height: auto;'>" +
                    "</div>" +
                    "<div style='background-color: #f8f9fa; padding: 20px; border-radius: 5px;'>" +
                    "<p>Xin chào %s,</p>" +
                    "<p>Xin chân thành cảm ơn bạn vì đã sử dụng dịch vụ của chúng tôi!</p>" +
                    "<p>Cellphones xin thông báo tài khoản của bạn đã được đăng ký thành công. Vui lòng click vào button bên dưới để đến trang xác thực email của bạn.</p>" +
                    "<p style='text-align: center;'><a href='%s' style='display: inline-block; padding: 10px 20px; background-color: #dc3545; color: white; text-decoration: none; border-radius: 5px;'>Xác thực email</a></p>" +
                    "</div>" +
                    "</div>" +
                    "</body>" +
                    "</html>";

    public static String generateEmailContent(String userEmail, String verificationLink) {
        return String.format(HTML_TEMPLATE, userEmail, verificationLink);
    }
}
