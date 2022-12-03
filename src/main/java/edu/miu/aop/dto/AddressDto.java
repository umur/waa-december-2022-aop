package edu.miu.aop.dto;

import edu.miu.aop.entity.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
public class AddressDto {
    private int id;
    private String street;
    private int zip;
    private String city;

    @JsonIgnoreProperties("address")
    private UserDto user;
}
