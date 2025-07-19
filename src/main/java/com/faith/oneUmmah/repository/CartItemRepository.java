package com.faith.oneUmmah.repository;

import com.faith.oneUmmah.domain.CartItem;

public interface CartItemRepository {
    CartItem save(CartItem cartItem);
    CartItem update(CartItem cartItem);
}
