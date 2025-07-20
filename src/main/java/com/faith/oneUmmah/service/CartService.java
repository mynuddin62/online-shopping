package com.faith.oneUmmah.service;

import com.faith.oneUmmah.domain.Cart;
import com.faith.oneUmmah.domain.User;

public interface CartService {
    Cart getCartByUser(User currentUser);
    void addProductToCart(String productId, Cart cart);
    void removeProductToCart(String productId, Cart cart);
}
