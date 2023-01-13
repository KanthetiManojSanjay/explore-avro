package com.learnavro.dto;

import com.learnavro.domain.generated.PickUp;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author kansanja on 12/01/23.
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CoffeeOrderDTO {

    private String id;
    private String name;
    private String nickName;
    private StoreDTO store;
    private List<OrderLineItemDTO> orderLineItems;
    private PickUp pickUp;
    private String status;
    private LocalDateTime orderedTime;


}
