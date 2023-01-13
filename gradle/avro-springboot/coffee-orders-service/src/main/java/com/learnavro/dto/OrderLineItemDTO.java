package com.learnavro.dto;

import com.learnavro.domain.generated.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @author kansanja on 12/01/23.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderLineItemDTO {
    private String name;
    private Size size;
    private Integer quantity;
    private BigDecimal cost;
}
