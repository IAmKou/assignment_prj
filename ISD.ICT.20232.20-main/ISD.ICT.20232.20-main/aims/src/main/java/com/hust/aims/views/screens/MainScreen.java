package com.hust.aims.views.screens;

import com.hust.aims.AimsApplication;
import com.hust.aims.views.screens.cart.CartScreen;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import org.springframework.stereotype.Controller;

@Controller
public class MainScreen {

    @FXML
    private ImageView cartIcon;

    @FXML
    private Button confirmButton;

    @FXML
    void handlerCartIcon(MouseEvent event) {
        handlerMoveToCart(event);
    }

    @FXML
    void handlerMoveToCart(MouseEvent event) {
        System.out.println("You clicked cart button");
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/CartScreen.fxml"));
            fxmlLoader.setControllerFactory(AimsApplication.springContext::getBean);
            BorderPane root = (BorderPane) fxmlLoader.load();
            CartScreen cartScreen = fxmlLoader.getController();
            cartScreen.setUserID(1);
            Scene scene = new Scene(root);
            AimsApplication.primaryStage.setScene(scene);
            AimsApplication.primaryStage.show();
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("Can not load CartScreen.fxml");
        }
    }

}
