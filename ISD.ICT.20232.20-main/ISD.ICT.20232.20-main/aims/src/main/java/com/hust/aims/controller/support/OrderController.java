package com.hust.aims.controller.support;

import com.hust.aims.entities.cart.Cart;
import com.hust.aims.entities.cart.CartProduct;
import com.hust.aims.entities.order.Order;
import com.hust.aims.repository.cart.CartProductRepository;
import com.hust.aims.repository.cart.CartRepository;
import com.hust.aims.repository.customer.CustomerRepository;
import com.hust.aims.repository.order.OrderRepository;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Optional;

@Controller
public class OrderController {

    private final ProductController productController;
    private final CartRepository cartRepository;
    private final CustomerRepository customerRepository;
    private final CartProductRepository cartProductRepository;
    private final OrderRepository orderRepository;

    public OrderController(
            ProductController productController,
            CartRepository cartRepository,
            CustomerRepository customerRepository,
            CartProductRepository cartProductRepository,
            OrderRepository orderRepository
    ) {
        this.productController = productController;
        this.cartRepository = cartRepository;
        this.customerRepository = customerRepository;
        this.cartProductRepository = cartProductRepository;
        this.orderRepository = orderRepository;
    }


    public boolean isSatisfiedOrder(Integer cartId, Integer customerId) {
        if (!customerRepository.existsById(customerId)) return false;

        Optional<Cart> cartOptional = cartRepository.findById(cartId);
        if (cartOptional.isEmpty()) return false;

        List<CartProduct> cartProducts = cartProductRepository.findAllByIdCartId(cartId);
        boolean containInsufficientQuantityProduct = cartProducts
                .stream()
                .anyMatch(cartProduct -> !productController.isSufficientQuantity(cartProduct.getProduct(), 1));
        return !containInsufficientQuantityProduct;
    }

    public void placeOrder(Order order, Integer cartId) {
        orderRepository.save(order);
        cartProductRepository.deleteAllByCartId(cartId);
    }
}
