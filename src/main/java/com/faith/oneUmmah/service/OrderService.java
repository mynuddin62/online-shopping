package com.faith.oneUmmah.service;

import com.faith.oneUmmah.domain.User;
import com.faith.oneUmmah.dto.ShippingAddressDTO;

public interface OrderService {
    void processOrder(ShippingAddressDTO shippingAddressDTO, User currentUser);
}
