package miu.edu.springaop.dto;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import java.util.List;

@Data
public class UserDto {

    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
//    private boolean isDeleted;

//    @JsonIgnoreProperties("User")
    @JsonManagedReference
    private List<ReviewDto> reviews;

//    @JsonIgnoreProperties("User")
    @JsonManagedReference
    private AddressDto address;
}
