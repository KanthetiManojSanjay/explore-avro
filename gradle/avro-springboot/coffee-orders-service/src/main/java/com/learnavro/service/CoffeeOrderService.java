package com.learnavro.service;

import com.learnavro.domain.generated.*;
import com.learnavro.dto.CoffeeOrderDTO;
import com.learnavro.dto.CoffeeOrderUpdateDTO;
import com.learnavro.dto.OrderLineItemDTO;
import com.learnavro.producer.CoffeeOrderProducer;
import com.learnavro.producer.CoffeeOrderUpdateProducer;
import org.springframework.stereotype.Service;

import java.time.ZoneOffset;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * @author kansanja on 12/01/23.
 */
@Service
public class CoffeeOrderService {

    private CoffeeOrderProducer coffeeOrderProducer;
    private CoffeeOrderUpdateProducer coffeeOrderUpdateProducer;

    public CoffeeOrderService(CoffeeOrderProducer coffeeOrderProducer,CoffeeOrderUpdateProducer coffeeOrderUpdateProducer) {
        this.coffeeOrderProducer = coffeeOrderProducer;
        this.coffeeOrderUpdateProducer= coffeeOrderUpdateProducer;
    }

    public CoffeeOrderDTO newOrder(CoffeeOrderDTO coffeeOrderDto) {

        var coffeeOrderAvro = mapToCoffeeOrder(coffeeOrderDto);
        coffeeOrderProducer.sendMessage(coffeeOrderAvro);
        coffeeOrderDto.setId(coffeeOrderAvro.getId().toString());
        return coffeeOrderDto;
    }

    private CoffeeOrder mapToCoffeeOrder(CoffeeOrderDTO coffeeOrderDto) {

        var store= getStore(coffeeOrderDto);

        List<OrderLineItem> orderLineItems = buildOrderLineItems(coffeeOrderDto.getOrderLineItems());

        return CoffeeOrder.newBuilder()
                .setId(UUID.randomUUID())
                .setName(coffeeOrderDto.getName())
                .setNickName(coffeeOrderDto.getNickName())
                .setStore(store)
                .setOrderLineItems(orderLineItems)
//                .setOrderedTime(Instant.now())
                .setOrderedTime(coffeeOrderDto.getOrderedTime().toInstant(ZoneOffset.UTC))
                .setPickUp(coffeeOrderDto.getPickUp())
                .setStatus(coffeeOrderDto.getStatus()).build();
    }

    private List<OrderLineItem> buildOrderLineItems(List<OrderLineItemDTO> orderLineItems) {
        return orderLineItems.stream().map( orderLineItemDTO -> new OrderLineItem(
                orderLineItemDTO.getName(),
                orderLineItemDTO.getSize(),
                orderLineItemDTO.getQuantity(),
                orderLineItemDTO.getCost()

        )).collect(Collectors.toList());
    }

    private Store getStore(CoffeeOrderDTO coffeeOrderDto) {
        var store = coffeeOrderDto.getStore();
        return Store.newBuilder()
                .setId(store.getStoreId())
                .setAddress(
                       new Address(
                               store.getAddress().getAddressLine1(),
                               store.getAddress().getCity(),
                               store.getAddress().getState(),
                               store.getAddress().getCountry(),
                               store.getAddress().getZip()
                       ))
                .build();
    }

    public CoffeeOrderUpdateDTO updateOrder(String orderId, CoffeeOrderUpdateDTO coffeeOrderUpdateDTO) {
        var coffeeUpdateEvent= mapToCoffeeOrderUpdate(orderId,coffeeOrderUpdateDTO);
        coffeeOrderUpdateProducer.sendMessage(coffeeUpdateEvent);
        return coffeeOrderUpdateDTO;
    }

    private CoffeeUpdateEvent mapToCoffeeOrderUpdate(String orderId, CoffeeOrderUpdateDTO coffeeOrderUpdateDTO) {
        return CoffeeUpdateEvent.newBuilder()
                .setId(UUID.fromString(orderId))
                .setStatus(coffeeOrderUpdateDTO.getOrderStatus())
                .build();
    }
}
