package com.hust.aims.views.screens.placeorder;

import com.hust.aims.controller.PayOrderController;
import com.hust.aims.module.Invoice;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import org.springframework.stereotype.Controller;

@Controller
public class InvoiceScreen {


    private Invoice invoice;

    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
        address.setText(invoice.getDeliveryInfo().getAddress());
        createdDate.setText(invoice.getOrder().getCreatedDate().toString());
        name.setText(invoice.getDeliveryInfo().getReceiverName());
        orderId.setText(invoice.getOrder().getId().toString());
        phone.setText(invoice.getDeliveryInfo().getPhoneNumber());
        productPrice.setText(invoice.getOrder().getTotalPrice().toString());
        shippingFee.setText(invoice.getOrder().getShippingFee().toString());
        float total = invoice.getOrder().getTotalPrice() + invoice.getOrder().getShippingFee();
        totalPrice.setText(Float.toString(total));
    }

    private PayOrderController payOrderController;

    public void setPayOrderController(PayOrderController payOrderController) {
        this.payOrderController = payOrderController;
    }

    @FXML
    private Label address;

    @FXML
    private Button confirmButton;

    @FXML
    private Label createdDate;

    @FXML
    private Label name;

    @FXML
    private Label orderId;

    @FXML
    private Label phone;

    @FXML
    private Label productPrice;

    @FXML
    private Label shippingFee;

    @FXML
    private Label totalPrice;


    @FXML
    void handlerConfirmOrder(MouseEvent event) {
        payOrderController.processPaymentAndSaveResult();
    }

}
