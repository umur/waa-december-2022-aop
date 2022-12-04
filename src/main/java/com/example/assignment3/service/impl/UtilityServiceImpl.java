package com.example.assignment3.service.impl;

import com.example.assignment3.service.UtilityService;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class UtilityServiceImpl implements UtilityService {
    @Override
    public int getRandomNumber() {
        Random rr = new Random();
        return rr.nextInt(200);
    }
}
