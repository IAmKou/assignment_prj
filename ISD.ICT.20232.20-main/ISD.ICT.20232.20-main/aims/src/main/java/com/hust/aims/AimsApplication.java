package com.hust.aims;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import javax.swing.*;

@SpringBootApplication
public class AimsApplication extends Application {

	public static ConfigurableApplicationContext springContext;

	public static Stage primaryStage;

	public static void main(String[] args) {
		launch();
		SpringApplication.run(AimsApplication.class, args);
	}


	@Override
	public void start(Stage primaryStage) throws Exception {
		springContext = SpringApplication.run(AimsApplication.class);
		FXMLLoader loader = new FXMLLoader(AimsApplication.class.getResource("/fxml/main.fxml"));
		loader.setControllerFactory(springContext::getBean);
		AnchorPane root = (AnchorPane) loader.load();
		Scene scene = new Scene(root);
		AimsApplication.primaryStage = primaryStage;
		primaryStage.setTitle("Aims Application");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	@Override
	public void stop() {
		springContext.close();
	}
}
