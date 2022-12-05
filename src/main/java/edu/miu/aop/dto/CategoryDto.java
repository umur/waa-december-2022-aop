package edu.miu.aop.dto;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import edu.miu.aop.entity.Product;
import lombok.Data;

import java.util.List;

/**
 * @author Ankhbayar Azzaya
 */
@Data
public class CategoryDto {
    private int id;
    private String name;
    private List<ProductDto> products;
}
