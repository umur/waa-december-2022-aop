package edu.miu.aop.dto;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.List;

/**
 * @author Ankhbayar Azzaya
 */
@Data
public class UserDto {
    private int id;
    private String email;
    private String password;
    private String firstname;
    private String lastname;

    private List<ReviewDto> reviews;
}
