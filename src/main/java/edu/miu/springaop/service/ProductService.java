package edu.miu.springaop.service;

import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@NoArgsConstructor
public class ProductService {
    public void testService(){
        System.out.println("I'm test service");
    }
}
