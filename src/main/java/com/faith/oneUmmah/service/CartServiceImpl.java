package com.faith.oneUmmah.service;

import com.faith.oneUmmah.domain.Cart;
import com.faith.oneUmmah.domain.CartItem;
import com.faith.oneUmmah.domain.Product;
import com.faith.oneUmmah.domain.User;
import com.faith.oneUmmah.exception.ProductNotFoundException;
import com.faith.oneUmmah.repository.CartItemRepository;
import com.faith.oneUmmah.repository.CartRepository;
import com.faith.oneUmmah.repository.ProductRepository;

import java.math.BigDecimal;
import java.util.Optional;


public class CartServiceImpl implements CartService{
    private final CartRepository cartRepository;
    private final ProductRepository productRepository;
    private final CartItemRepository cartItemRepository;

    public CartServiceImpl(CartRepository cartRepository, ProductRepository productRepository, CartItemRepository cartItemRepository) {
        this.cartRepository = cartRepository;
        this.productRepository = productRepository;
        this.cartItemRepository = cartItemRepository;
    }

    @Override
    public Cart getCartByUser(User currentUser) {
        return cartRepository.findByUser(currentUser).orElseGet(() -> createNewCart(currentUser));
    }

    @Override
    public void addProductToCart(String productId, Cart cart) {
        if(productId == null || productId.isBlank()) {
            throw new IllegalArgumentException("Product id can not be null or blank");
        }

        Long id = parseProductId(productId);

        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("Product not found by id: " + id));

        addProductToCart(product, cart);

        Integer totalTotalItem = getTotalItem(cart);
        BigDecimal totalPrice = calculateTotalPrice(cart);

        cart.setTotalItem(totalTotalItem);
        cart.setTotalPrice(totalPrice);

        cartRepository.update(cart);
    }

    private void addProductToCart(Product product, Cart cart) {
        Optional<CartItem> optionalCartItem = findSimilarProductInCart(cart, product);

        CartItem cartItem = optionalCartItem
                .map(this::increaseQuantityByOne)
                .orElseGet(() -> createNewShoppingCartItem(product));

        cart.getCartItems().add(cartItem);
    }

    private CartItem createNewShoppingCartItem(Product product) {
        var cartItem = new CartItem();
        cartItem.setProduct(product);
        cartItem.setQuantity(1);
        cartItem.setPrice(product.getPrice());

        return cartItemRepository.save(cartItem);
    }

    private CartItem increaseQuantityByOne(CartItem cartItem) {
        cartItem.setQuantity(cartItem.getQuantity()+ 1);

        BigDecimal totalPrice = cartItem.getProduct().getPrice().multiply(BigDecimal.valueOf(cartItem.getQuantity()));
        cartItem.setPrice(totalPrice);

        return cartItemRepository.update(cartItem);

    }

    private Optional<CartItem> findSimilarProductInCart(Cart cart, Product product) {
        return cart.getCartItems().stream().filter(cartItem -> cartItem.getProduct().equals(product)).findFirst();
    }

    private Integer getTotalItem(Cart cart) {
        return cart.getCartItems().stream().map(CartItem::getQuantity).reduce(0,Integer::sum);
    }

    private BigDecimal calculateTotalPrice(Cart cart) {
        return cart.getCartItems().stream().map(CartItem::getPrice).reduce(BigDecimal.ZERO,BigDecimal::add);
    }

    private Long parseProductId(String productId) {
        try {
            return Long.parseLong(productId);
        } catch (NumberFormatException ex) {
            throw new IllegalArgumentException("Product id must be a whole number", ex);
        }
    }

    private Cart createNewCart(User currentUser) {
        Cart cart = new Cart();
        cart.setUser(currentUser);
        return cartRepository.save(cart);
    }

}
