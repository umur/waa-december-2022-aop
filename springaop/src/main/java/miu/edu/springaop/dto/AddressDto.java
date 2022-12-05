package miu.edu.springaop.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;


@Data
public class AddressDto {
    private int id;
    private String street;
    private int zip;
    private String city;

//    @JsonIgnoreProperties("address")
    @JsonBackReference
    private UserDto user;
    private AuditFieldsDto auditFields;

}
