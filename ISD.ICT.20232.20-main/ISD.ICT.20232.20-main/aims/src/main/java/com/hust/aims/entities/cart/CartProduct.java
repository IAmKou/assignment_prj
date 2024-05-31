package com.hust.aims.entities.cart;

import com.hust.aims.entities.product.Product;
import jakarta.persistence.*;

@Entity
@Table(name = "cart_product")
public class CartProduct {
    @EmbeddedId
    private CartProductId id;

    @MapsId("cartId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "cart_id", nullable = false)
    private Cart cart;

    @MapsId("productId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    public CartProductId getId() {
        return id;
    }

    public void setId(CartProductId id) {
        this.id = id;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

}