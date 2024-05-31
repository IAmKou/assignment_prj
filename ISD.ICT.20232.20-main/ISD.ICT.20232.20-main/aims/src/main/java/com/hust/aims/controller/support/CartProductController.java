package com.hust.aims.controller.support;

import com.hust.aims.entities.cart.CartProduct;
import com.hust.aims.entities.cart.CartProductId;
import com.hust.aims.repository.cart.CartProductRepository;
import com.hust.aims.repository.cart.CartRepository;
import com.hust.aims.repository.product.ProductRepository;
import org.springframework.stereotype.Service;

@Service
public class CartProductController {

    private final CartProductRepository cartProductRepository;
    private final CartRepository cartRepository;
    private final ProductRepository productRepository;

    public CartProductController(
            CartProductRepository cartProductRepository,
            CartRepository cartRepository,
            ProductRepository productRepository
    ) {
        this.cartProductRepository = cartProductRepository;
        this.cartRepository = cartRepository;
        this.productRepository = productRepository;
    }

    public CartProduct addProductToCart(Integer cartId, Integer productId) {
        if(!cartRepository.existsById(cartId)) return null;
        if(!productRepository.existsById(productId)) return null;

        CartProductId cartProductId = new CartProductId();
        cartProductId.setCartId(cartId);
        cartProductId.setProductId(productId);
        CartProduct cartProduct = new CartProduct();
        cartProduct.setId(cartProductId);

        return cartProductRepository.save(cartProduct);
    }
}
