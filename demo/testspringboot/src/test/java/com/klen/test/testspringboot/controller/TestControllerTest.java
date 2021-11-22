package com.klen.test.testspringboot.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Description:
 * @Author: Jianyu Qiu (Kalen)
 * @CreateTime: 2021/11/14
 */
@SpringBootTest
class TestControllerTest {

    @Autowired
    private TestController testController;

    @Test
    void testTest() {
        testController.test();
    }
}