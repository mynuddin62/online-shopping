package com.faith.oneUmmah.repository;

import com.faith.oneUmmah.domain.ShippingAddress;

import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

public class ShippingAddressRepositoryImpl implements ShippingAddressRepository {
    private static final Set<ShippingAddress> SHIPPING_ADDRESS = new CopyOnWriteArraySet<>();
    @Override
    public ShippingAddress save(ShippingAddress shippingAddress) {
        SHIPPING_ADDRESS.add(shippingAddress);
        return shippingAddress;
    }
}
