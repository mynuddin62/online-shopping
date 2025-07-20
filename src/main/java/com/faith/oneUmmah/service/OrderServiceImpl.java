package com.faith.oneUmmah.service;

import com.faith.oneUmmah.domain.Cart;
import com.faith.oneUmmah.domain.Order;
import com.faith.oneUmmah.domain.ShippingAddress;
import com.faith.oneUmmah.domain.User;
import com.faith.oneUmmah.dto.ShippingAddressDTO;
import com.faith.oneUmmah.exception.CartItemNotFoundException;
import com.faith.oneUmmah.repository.CartRepository;
import com.faith.oneUmmah.repository.OrderRepository;
import com.faith.oneUmmah.repository.ShippingAddressRepository;

public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    private final ShippingAddressRepository shippingAddressRepository;
    private final CartRepository cartRepository;

    public OrderServiceImpl(OrderRepository orderRepository, ShippingAddressRepository shippingAddressRepository, CartRepository cartRepository) {
        this.orderRepository = orderRepository;
        this.shippingAddressRepository = shippingAddressRepository;
        this.cartRepository = cartRepository;
    }

    @Override
    public void processOrder(ShippingAddressDTO shippingAddressDTO, User currentUser) {
        ShippingAddress shippingAddress = convertTo(shippingAddressDTO);
        ShippingAddress savedShippingAddress = shippingAddressRepository.save(shippingAddress);

        Cart cart = cartRepository.findByUser(currentUser)
                .orElseThrow(() -> new CartItemNotFoundException("Cart not found by " + currentUser.getUsername()));

        Order order = new Order();
        order.setCart(cart);
        order.setShippingAddress(savedShippingAddress);
        order.setShipped(false);
        order.setUser(currentUser);

        orderRepository.save(order);

    }


    private ShippingAddress convertTo(ShippingAddressDTO shippingAddressDTO) {
        ShippingAddress shippingAddress = new ShippingAddress();
        shippingAddress.setAddress(shippingAddressDTO.getAddress());
        shippingAddress.setAddress2(shippingAddressDTO.getAddress2());
        shippingAddress.setCity(shippingAddressDTO.getCity());
        shippingAddress.setThana(shippingAddressDTO.getThana());
        shippingAddress.setPostalCode(shippingAddressDTO.getPostalCode());
        shippingAddress.setMobileNumber(shippingAddressDTO.getMobileNumber());
        shippingAddress.setMobileNumber2(shippingAddressDTO.getMobileNumber2());
        return shippingAddress;
    }
}
