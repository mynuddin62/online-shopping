package com.faith.oneUmmah.repository;

import com.faith.oneUmmah.domain.Cart;
import com.faith.oneUmmah.domain.User;

import java.util.Optional;

public interface CartRepository {
    Optional<Cart> findByUser(User currentUser);

    Cart save(Cart cart);
    Cart update(Cart cart);
}
