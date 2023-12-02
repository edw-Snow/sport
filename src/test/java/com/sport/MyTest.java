package com.sport;


import org.junit.jupiter.api.Test;

public class MyTest {
    public static void main(String[] args) {
        System.out.println("hello");
    }

    @Test
    public void f() {
        try {
            int a = 1 / 0;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println("hello");
    }
}
