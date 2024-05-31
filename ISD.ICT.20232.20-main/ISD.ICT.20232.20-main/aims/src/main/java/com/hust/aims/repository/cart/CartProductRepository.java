package com.hust.aims.repository.cart;

import com.hust.aims.entities.cart.CartProduct;
import com.hust.aims.entities.cart.CartProductId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartProductRepository extends JpaRepository<CartProduct, CartProductId> {

    List<CartProduct> findAllByIdCartId(Integer cartId);

    void deleteAllByCartId(Integer cartId);
}