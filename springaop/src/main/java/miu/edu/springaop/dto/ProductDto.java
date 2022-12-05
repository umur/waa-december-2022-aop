package miu.edu.springaop.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ProductDto {

    private int id;
    private String name;
    private double price;
//    private boolean isDeleted;

    private AuditFieldsDto auditFields;

//    @JsonIgnoreProperties("product")
    @JsonManagedReference
    private List<ReviewDto> reviews;

//    @JsonIgnoreProperties("product")
    @JsonBackReference
    private CategoryDto category;

}
