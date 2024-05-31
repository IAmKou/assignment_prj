package com.hust.aims.views.screens.placeorder;

import com.hust.aims.controller.PlaceOrderController;
import com.hust.aims.entities.customer.DeliveryInfo;
import com.hust.aims.repository.customer.DeliveryInfoRepository;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import java.time.Instant;

@Controller
public class ShippingScreen {

    @Autowired
    DeliveryInfoRepository  deliveryInfoRepository;

    private PlaceOrderController placeOrderController;

    public void setPlaceOrderController(PlaceOrderController placeOrderController) {
        this.placeOrderController = placeOrderController;
    }

    @FXML
    private Button btnConfirm;

    @FXML
    private TextField txtAddress;

    @FXML
    private TextField txtCity;

    @FXML
    private TextField txtDate;

    @FXML
    private TextField txtInstruction;

    @FXML
    private TextField txtName;

    @FXML
    private TextField txtPhone;

    @FXML
    private TextField txtProvince;

    @FXML
    private TextField txtTime;

    @FXML
    void handleConfirm(ActionEvent event) {
        DeliveryInfo deliveryInfo = new DeliveryInfo();
        deliveryInfo.setAddress(txtAddress.getText() +" City: " + txtCity.getText());
        deliveryInfo.setPhoneNumber(txtPhone.getText());
        deliveryInfo.setProvince(txtProvince.getText());
        deliveryInfo.setReceiverName(this.txtName.getText());
        deliveryInfo.setDeliveryTime(Instant.now());
        deliveryInfo.setInstructions(txtInstruction.getText());
        deliveryInfo.setId(deliveryInfoRepository.findAll().size()+1);
        deliveryInfoRepository.save(deliveryInfo);
        placeOrderController.submitDeliveryInfo(deliveryInfo);
    }

}
