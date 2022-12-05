package miu.edu.springaop.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import miu.edu.springaop.entity.AuditFields;
import miu.edu.springaop.entity.Product;

import java.util.List;

@Data
public class CategoryDto {
    private int id;
    private String name;
    private AuditFieldsDto auditFields;

//    @JsonIgnoreProperties("category")
    @JsonManagedReference
    private List<ProductDto> products;

}
