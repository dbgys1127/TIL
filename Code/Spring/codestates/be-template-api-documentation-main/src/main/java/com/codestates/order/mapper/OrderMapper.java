package com.codestates.order.mapper;

import com.codestates.coffee.entity.Coffee;
import com.codestates.member.entity.Member;
import com.codestates.order.dto.OrderCoffeeResponseDto;
import com.codestates.order.dto.OrderPatchDto;
import com.codestates.order.dto.OrderPostDto;
import com.codestates.order.dto.OrderResponseDto;
import com.codestates.order.entity.Order;
import com.codestates.order.entity.OrderCoffee;
import org.mapstruct.Mapper;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface OrderMapper {
    Order orderPatchDtoToOrder(OrderPatchDto orderPatchDto);
    List<OrderResponseDto> ordersToOrderResponseDtos(List<Order> orders);

    default Order orderPostDtoToOrder(OrderPostDto orderPostDto) {
        Order order = new Order();
        Member member = new Member();
        member.setMemberId(orderPostDto.getMemberId());

        List<OrderCoffee> orderCoffees = orderPostDto.getOrderCoffees().stream()
                        .map(orderCoffeeDto -> {
                            OrderCoffee orderCoffee = new OrderCoffee();
                            Coffee coffee = new Coffee();
                            coffee.setCoffeeId(orderCoffeeDto.getCoffeeId());
                            orderCoffee.addOrder(order);
                            orderCoffee.addCoffee(coffee);
                            orderCoffee.setQuantity(orderCoffeeDto.getQuantity());
                            return orderCoffee;
                        }).collect(Collectors.toList());
        order.setMember(member);
        order.setOrderCoffees(orderCoffees);

        return order;
    }

    default OrderResponseDto orderToOrderResponseDto(Order order){
        List<OrderCoffee> orderCoffees = order.getOrderCoffees();

        OrderResponseDto orderResponseDto = new OrderResponseDto();
        orderResponseDto.setOrderId(order.getOrderId());
        orderResponseDto.setMember(order.getMember());
        orderResponseDto.setOrderStatus(order.getOrderStatus());
        orderResponseDto.setCreatedAt(order.getCreatedAt());
        orderResponseDto.setOrderCoffees(
                orderCoffeesToOrderCoffeeResponseDtos(orderCoffees)
        );

        return orderResponseDto;
    }

    default List<OrderCoffeeResponseDto> orderCoffeesToOrderCoffeeResponseDtos(
                                                    List<OrderCoffee> orderCoffees) {
        return orderCoffees
                .stream()
                .map(orderCoffee -> OrderCoffeeResponseDto
                        .builder()
                        .coffeeId(orderCoffee.getCoffee().getCoffeeId())
                        .quantity(orderCoffee.getQuantity())
                        .price(orderCoffee.getCoffee().getPrice())
                        .korName(orderCoffee.getCoffee().getKorName())
                        .engName(orderCoffee.getCoffee().getEngName())
                        .build())
                .collect(Collectors.toList());
    }
}
