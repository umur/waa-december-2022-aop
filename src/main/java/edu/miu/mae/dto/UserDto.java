package edu.miu.mae.dto;

import edu.miu.mae.entity.Address;
import edu.miu.mae.entity.Review;
import lombok.Data;
import java.util.List;

@Data
public class UserDto {
    private int id;

    private String email;

    private String password;

    private String firstName;

    private String lastName;

    private Address address;

    private List<ReviewDto> listReviews;
}
