package com.hust.aims.views.screens.cart;

import com.hust.aims.controller.PlaceOrderController;
import com.hust.aims.entities.cart.CartProduct;
import com.hust.aims.entities.order.Order;
import com.hust.aims.entities.product.Product;
import com.hust.aims.module.Item;
import com.hust.aims.repository.cart.CartProductRepository;
import com.hust.aims.repository.product.ProductRepository;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Optional;

@Controller
public class CartScreen {

    @Autowired
    CartProductRepository cartProductRepository;
    @Autowired
    ProductRepository productRepository;

    public void setUserID(Integer userID) {
        List<CartProduct> cartProductList = cartProductRepository.findAllByIdCartId(userID);
        List<Item> items = new java.util.ArrayList<>(List.of());
        for(CartProduct cartProduct : cartProductList){
            Optional<Product> productOptional = productRepository.findById(cartProduct.getId().getProductId());
            if(productOptional.isPresent()){
                Product product = productOptional.get();
                items.add(new Item(product.getName(),"1", product.getPrice().toString()));
            }
        }
        itemList.getItems().addAll(items);
    }

    @FXML
    private Button btnPlaceOrder;

    @FXML
    private VBox cartItems;

    @FXML
    private CheckBox chkRush;

    @FXML
    private ListView<Item> itemList; // TODO: change cart item class name

    @FXML
    private Label lbFeeEligible;

    @FXML
    private Label lbFeeIneligible;

    @FXML
    private Label lbSubtotal;

    @FXML
    private Label lbTotal;

    @Autowired
    PlaceOrderController placeOrderController;

    @FXML
    void handlePlaceOrder(ActionEvent event) {
        //Create Order in db here
        //TODO
        Order order = new Order();
        order.setId(1);
        //place order process with order
        placeOrderController.askToPlaceOrder(order.getId());

    }

}
