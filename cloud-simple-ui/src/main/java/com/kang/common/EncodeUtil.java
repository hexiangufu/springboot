package com.kang.common;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class EncodeUtil {

    /**
     * 密码加密
     * @param password
     * @return
     */
    public static String passwordEncode(String password){
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder.encode(password);
    }

    public static void main(String[] args) {
        String pswd1=EncodeUtil.passwordEncode("abcd");
        System.out.println(pswd1);
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        System.out.println(encoder.matches("abcd",pswd1));
        System.out.println(pswd1);
    }
}
