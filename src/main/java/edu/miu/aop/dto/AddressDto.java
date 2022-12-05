package edu.miu.aop.dto;

import lombok.Data;

/**
 * @author Ankhbayar Azzaya
 */
@Data
public class AddressDto {
    private int id;
    private String street;
    private int zip;
    private String city;
}
