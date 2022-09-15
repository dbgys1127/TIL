package com.codestates.slice.controller.order;

import com.codestates.exception.BusinessLogicException;
import com.codestates.helper.StubData;
import com.codestates.order.entity.Order;
import com.codestates.order.repository.OrderRepository;
import com.codestates.order.service.OrderService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.function.Executable;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
public class OrderServiceHomeworkTest {
    @Mock
    private OrderRepository orderRepository;

    @InjectMocks
    private OrderService orderService;

    @Test
    public void cancelOrderTest() {
        // given
        long orderId = 1L;
        Order order = StubData.MockOrder.getSingleResponseBody(orderId);

        // Stubbing by Mockito
        given(orderRepository.findById(orderId)).willReturn(Optional.of(order));

        // when
        Executable executable = () -> orderService.cancelOrder(orderId);

        // then
        assertThrows(BusinessLogicException.class, executable);
    }
}
