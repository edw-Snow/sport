package com.sport;

import com.sport.common.util.Md5Util;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SportAckendApplicationTests {


    public static void main(String[] args) {
        String salt = Md5Util.createSalt();
        System.out.println(salt);
        String password = Md5Util.createMd5Password("shanguanTang",salt);
        System.out.println(password);
    }
}
