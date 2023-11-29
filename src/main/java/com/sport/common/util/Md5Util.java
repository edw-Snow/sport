package com.sport.common.util;

import java.security.SecureRandom;
import java.util.Base64;

public class Md5Util {
    /**
     * 生成随机盐
     * @return
     */
    public static String createSalt(){
        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[16];
        random.nextBytes(salt);
        String encodeSalt = Base64.getEncoder().encodeToString(salt);
        return encodeSalt;
    }

    public static String createPassword(){
        return null;
    }

    public static void main(String[] args) {
        System.out.println("hello");
    }
}
