package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import javax.swing.text.html.Option;
import java.util.Optional;

public class Main extends Application {

    TextField NameTextField = new TextField();
    TextField PhoneTextField = new TextField();
    TextField BroncoIDTextField = new TextField();

    Button button = new Button("Save Changes");

    Label labelName = new Label("Name: ");
    Label labelPhone = new Label("Phone: ");
    Label labelBroncoID = new Label("BroncoID: ");

    Label mainLabel = new Label("Edit Student");

    @Override
    public void start(Stage primaryStage) throws Exception{
        primaryStage.setTitle("In Class 7");

        //event stuff
        NameTextField.textProperty().addListener((observable, oldValue,
                                                  newValue) -> {
            if (newValue != oldValue) {
                NameTextField.setStyle("-fx-border-color: red ; " +
                        "-fx-border-style: solid;");
                button.setDisable(false);
            }
        });

        PhoneTextField.textProperty().addListener((observable, oldValue,
                                                   newValue) -> {
            if (newValue != oldValue) {
                PhoneTextField.setStyle("-fx-border-color: red ; " +
                        "-fx-border-style: solid;");
                button.setDisable(false);
            }
        });

        BroncoIDTextField.textProperty().addListener((observable, oldValue,
                                                      newValue) -> {
            if (newValue != oldValue) {
                BroncoIDTextField.setStyle("-fx-border-color: red ; " +
                        "-fx-border-style: solid;");
                button.setDisable(false);
            }
        });

        button.setOnAction(event -> {

            button.setDisable(true);
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION,
                    "You are saving your changes.");
            Optional<ButtonType> result = alert.showAndWait();
            if (result.isPresent() && result.get() == ButtonType.OK);

            NameTextField.setStyle("-fx-border-color: black");
            PhoneTextField.setStyle("-fx-border-color: black");
            BroncoIDTextField.setStyle("-fx-border-color: black");
        });


        //Vboxs
        HBox hboxMainLabel = new HBox(mainLabel);
        hboxMainLabel.setPadding(new Insets(10));

        VBox vBoxControls = new VBox(10, NameTextField, PhoneTextField,
                BroncoIDTextField);
        vBoxControls.setPadding(new Insets(25));

        VBox vBoxLabels = new VBox(20, labelName, labelPhone,
                labelBroncoID);
        vBoxLabels.setPadding(new Insets(25));

        //gridPanes
        GridPane gridPane = new GridPane();
        GridPane buttonGrid = new GridPane();
        GridPane gpMainLabel = new GridPane();

        //grid for text fields and their labels
        gridPane.add(vBoxControls, 2, 0);
        gridPane.add(vBoxLabels, 1, 0);

        //main label grid
        gpMainLabel.add(hboxMainLabel, 0, 0);
        gpMainLabel.setAlignment(Pos.CENTER);

        //grid for save button
        buttonGrid.add(button, 0, 0);
        buttonGrid.setAlignment(Pos.CENTER);
        buttonGrid.setPadding(new Insets(25));

        //for debugging
//        gridPane.setGridLinesVisible(true);
//        buttonGrid.setGridLinesVisible(true);

        //vbox that holds all the boxes
        VBox mainVbox = new VBox(gpMainLabel, gridPane, buttonGrid);

        Scene scene = new Scene(mainVbox);
        scene.getStylesheets().add("styleSheets.css");

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
