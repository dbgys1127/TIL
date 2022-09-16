package com.codestates.order.dto;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class OrderCoffeeResponseDto {
    private long coffeeId;
    private Integer quantity;
    private String korName;
    private String engName;
    private Integer price;
}
