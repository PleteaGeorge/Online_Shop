package com.example.InstantShop.service;

import com.example.InstantShop.entities.Orders;
import com.example.InstantShop.repository.OrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrdersService {
    @Autowired
    private OrdersRepository ordersRepository;
    public Orders save (Orders orders){
      return  ordersRepository.save(orders);
    }

}
