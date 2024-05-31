package com.hust.aims.controller;

import com.hust.aims.AimsApplication;
import com.hust.aims.entities.customer.DeliveryInfo;
import com.hust.aims.entities.customer.PaymentTransaction;
import com.hust.aims.entities.order.Order;
import com.hust.aims.module.Invoice;
import com.hust.aims.repository.customer.PaymentTransactionRepository;
import com.hust.aims.subsystem.IPayment;

import com.hust.aims.views.screens.placeorder.InvoiceScreen;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.concurrent.CompletableFuture;

@Controller
public class PayOrderController {

//  Repository for Persistence Layer
    @Autowired
    PaymentTransactionRepository paymentTransactionRepository;

//  Attributes
    private Invoice invoice;

    private IPayment iPayment;

    //start pay order
    public void askToPayOrder(Order order, DeliveryInfo deliveryInfo){
        invoice = new Invoice(deliveryInfo,order);
        displayInvoiceScreen();
    }

    private void displayInvoiceScreen(){
        // display new scene
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/InvoiceScreen.fxml"));
            AnchorPane root = (AnchorPane) fxmlLoader.load();
            InvoiceScreen invoiceScreen =  fxmlLoader.getController();
            invoiceScreen.setInvoice(invoice);
            invoiceScreen.setPayOrderController(this);
            fxmlLoader.setController(invoiceScreen);
            Scene scene = new Scene(root);
            AimsApplication.primaryStage.setScene(scene);
            AimsApplication.primaryStage.show();
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("Can not load InvoiceScreen.fxml");
        }

    }


    public void processPaymentAndSaveResult(){
        CompletableFuture<PaymentTransaction> completableFuture
                = CompletableFuture.supplyAsync(() -> iPayment.payOrder(invoice));
        while(!completableFuture.isDone()){
            System.out.println("Waiting for payment transaction...");
        }
        System.out.println("Received payment transaction");
        try {
            PaymentTransaction paymentTransaction = completableFuture.join();
            paymentTransaction.setId(paymentTransactionRepository.findAll().size() + 1);
            paymentTransactionRepository.save(paymentTransaction);
        }catch (Exception e){
            System.out.println("Something Wrong Here!!!");
        }
    }

    public IPayment getiPayment() {
        return iPayment;
    }

    public void setiPayment(IPayment iPayment) {
        this.iPayment = iPayment;
    }
}
