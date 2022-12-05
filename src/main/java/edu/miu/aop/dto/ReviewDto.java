package edu.miu.aop.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.ManyToOne;
import lombok.Data;

/**
 * @author Ankhbayar Azzaya
 */
@Data
public class ReviewDto {
    private int id;
    private String comment;

}
