package com.learnavro.controller;

import com.learnavro.dto.CoffeeOrderDTO;
import com.learnavro.dto.CoffeeOrderUpdateDTO;
import com.learnavro.service.CoffeeOrderService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 * @author kansanja on 12/01/23.
 */

@RestController
@RequestMapping("/v1/coffee_orders")
@Slf4j
@AllArgsConstructor
public class CoffeeOrderController {

    private CoffeeOrderService coffeeOrderService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CoffeeOrderDTO newOrder(@RequestBody CoffeeOrderDTO coffeeOrderDto){
        log.info("Received the request for an order: {}",coffeeOrderDto);
        return coffeeOrderService.newOrder(coffeeOrderDto);
    }

    @PutMapping("/{order_id}")
    @ResponseStatus(HttpStatus.OK)
    public CoffeeOrderUpdateDTO updateCoffeeOrder(@PathVariable("order_id") String orderId,
                                                  @RequestBody CoffeeOrderUpdateDTO coffeeOrderUpdateDTO){
        return coffeeOrderService.updateOrder(orderId, coffeeOrderUpdateDTO);
    }

}
