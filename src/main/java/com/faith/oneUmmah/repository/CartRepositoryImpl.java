package com.faith.oneUmmah.repository;

import com.faith.oneUmmah.domain.Cart;
import com.faith.oneUmmah.domain.User;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class CartRepositoryImpl implements CartRepository {
    private static final Map<User, Set<Cart>> CARTS = new ConcurrentHashMap<>();

    @Override
    public Optional<Cart> findByUser(User currentUser) {
        Set<Cart> carts = CARTS.get(currentUser);
        if(carts != null && !CARTS.isEmpty()) {
            Cart cart = (Cart) carts.toArray()[carts.size() - 1];
            return Optional.of(cart);
        }
        return Optional.empty();
    }

    @Override
    public Cart save(Cart cart) {
        CARTS.compute(cart.getUser(), (user, carts) -> {
            if (carts == null) {
                carts = new LinkedHashSet<>();
            }
            carts.add(cart);
            return carts;
        });

        return cart;
    }

    @Override
    public Cart update(Cart cart) {
        CARTS.computeIfPresent(cart.getUser(), (user, carts) -> {
            Cart[] objects = carts.toArray(Cart[]::new);
            objects[objects.length - 1] = cart;
            return new LinkedHashSet<>(Arrays.asList(objects));
        });
        return cart;
    }
}
