package com.hust.aims.views.screens.cart;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;

public class ItemScreen {

    @FXML
    private ImageView btnRemove;

    @FXML
    private ImageView itemImage;

    @FXML
    private Label itemName;

    @FXML
    private Label itemPrice;

    @FXML
    private Spinner<?> itemQuantity;

    @FXML
    private Label itemSinglePrice;

    @FXML
    void handleRemove(KeyEvent event) {

    }

}
