package com.gofers.requestserver.service;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RequestServiceTest {

    @Autowired
    RequestService requestService;


    @Test
    public void save() {

    }

    @Test
    public void findById() {
        System.out.println(requestService.findById(17));
    }
}
