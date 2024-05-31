package com.hust.aims.controller;

import com.hust.aims.AimsApplication;
import com.hust.aims.controller.support.OrderController;
import com.hust.aims.controller.support.PaymentController;
import com.hust.aims.entities.cart.Cart;
import com.hust.aims.entities.cart.CartProduct;
import com.hust.aims.entities.customer.Customer;
import com.hust.aims.entities.customer.DeliveryInfo;
import com.hust.aims.entities.customer.PaymentTransaction;
import com.hust.aims.entities.order.Order;
import com.hust.aims.entities.product.Product;
import com.hust.aims.repository.cart.CartProductRepository;
import com.hust.aims.repository.cart.CartRepository;
import com.hust.aims.repository.customer.CustomerRepository;
import com.hust.aims.repository.customer.PaymentTransactionRepository;
import com.hust.aims.repository.order.OrderRepository;
import com.hust.aims.repository.product.ProductRepository;
import com.hust.aims.subsystem.IPayment;
import com.hust.aims.views.screens.placeorder.ShippingScreen;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Controller
public class PlaceOrderController {

    @Autowired
    OrderController orderController;

    @Autowired
    CartRepository cartRepository;

    @Autowired
    CartProductRepository cartProductRepository;

    @Autowired
    ProductRepository productRepository;
    private DeliveryInfo deliveryInfo;

    private Cart cart;

    private Order order;

    private Float shippingCost;
    private float totalPrice = 0F;


    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private PaymentTransactionRepository paymentTransactionRepository;

    @Autowired
    PayOrderController payOrderController;
    public boolean askToPlaceOrder(Integer cartId) {

        Optional<Cart> cartOptional = cartRepository.findById(cartId);
        if(cartOptional.isEmpty()) {
            return false;
        }
        this.cart = cartOptional.get();

//        if (orderController.isSatisfiedOrder(cartId, cart.getId())){
            displayDeliveryFormScreen();
            return true;
//        }else{
//            System.out.println("Product quantity is not enough!");
//            return false;
//        }
    }

    private void displayDeliveryFormScreen() {
        try {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/Shipping.fxml"));
        fxmlLoader.setControllerFactory(AimsApplication.springContext::getBean);

        BorderPane root= (BorderPane) fxmlLoader.load();

        ShippingScreen shippingScreen = fxmlLoader.getController();
        shippingScreen.setPlaceOrderController(this);

        Scene scene = new Scene(root);
        AimsApplication.primaryStage.setScene(scene);
        AimsApplication.primaryStage.show();
        }catch (Exception e){
            System.out.println("Could not display shipping screen");
        }

    }

    public void submitDeliveryInfo(DeliveryInfo deliveryInfo){
        System.out.println("Delivery Info has been submitted");
        this.deliveryInfo = deliveryInfo;
        if(!checkDeliveryInfo()){
            System.out.println("Delivery InValid!!!");
        }else {
            updateDeliveryInfo();
            shippingCost = calculateShippingFee();
            order = new Order();
            order.setId(orderRepository.findAll().size()+1);
            order.setDelivery(deliveryInfo);
            order.setTotalPrice(totalPrice);
            order.setCreatedDate(LocalDate.now());

            Optional<Customer> optionalCustomer =  customerRepository.findById(cart.getId());
            if(optionalCustomer.isPresent()){
                Customer customer = optionalCustomer.get();
                order.setUser(customer);
            }
            order.setShippingFee(shippingCost);
            payOrderController.askToPayOrder(order,deliveryInfo);
        };

    }

    private boolean checkDeliveryInfo(){
        if(deliveryInfo==null){
            updateDeliveryInfo();
            return false;
        }
        return true;
    }

    private void updateDeliveryInfo(){

    }

    private Float calculateShippingFee(){
        if(cart==null){
            return 0F;
        }
        List<CartProduct> cartProductList = cartProductRepository.findAllByIdCartId(cart.getId());
        for(CartProduct cartProduct:cartProductList){
            Optional<Product> productOptional = productRepository.findById(cartProduct.getId().getProductId());
            if(productOptional.isPresent()){
                Product product = productOptional.get();
                totalPrice += product.getPrice();
            }
        }
        return totalPrice*0.1F;
    }
}

