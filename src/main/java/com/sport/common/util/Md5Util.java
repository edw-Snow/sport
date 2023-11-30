package com.sport.common.util;

import org.springframework.util.DigestUtils;

import java.security.SecureRandom;
import java.util.Base64;

public class Md5Util {
    /**
     * 生成随机盐
     *
     * @return
     */
    public static String createSalt() {
        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[16];
        random.nextBytes(salt);
        String encodeSalt = Base64.getEncoder().encodeToString(salt);
        return encodeSalt;
    }

    /**
     * 生成md5加密后的密码
     *
     * @param password
     * @return
     */
    public static String createMd5Password(String password, String salt) {
        return DigestUtils.md5DigestAsHex((salt + password).getBytes());
    }
}
