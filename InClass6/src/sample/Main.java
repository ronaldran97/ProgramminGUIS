package sample;

import javafx.application.Application;

import javafx.geometry.Insets;
import javafx.geometry.Pos;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

    Label label = new Label("Label");
    Button button = new Button("Button");
    TextField textField = new TextField();
    ChoiceBox<String> choiceBox = new ChoiceBox();

    @Override
    public void start(Stage primaryStage) throws Exception{

        primaryStage.setTitle("In Class 6");

        choiceBox.getItems().addAll("Option 1", "Option 2");

        VBox vBox = new VBox(10, label, button, textField, choiceBox);
        vBox.setAlignment(Pos.CENTER);
        vBox.setPadding(new Insets(10,10,10,10));

        Scene scene = new Scene(vBox, 1000, 1000);

        scene.getStylesheets().add("sample/styleSheet.css");
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
