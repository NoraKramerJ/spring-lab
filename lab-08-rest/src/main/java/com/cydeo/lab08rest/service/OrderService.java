package com.cydeo.lab08rest.service;

import com.cydeo.lab08rest.dto.OrderDTO;
import com.cydeo.lab08rest.entity.Order;
import com.cydeo.lab08rest.enums.PaymentMethod;

import java.util.List;

public interface OrderService {


   List<OrderDTO> retrieveListOrder();

   OrderDTO updateOrder(OrderDTO orderDTO);
}