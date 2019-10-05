package sample;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

    Label dataPlan = new Label("Data Plan (Select 1): ");
    Label phones = new Label("Phones (Select 1): ");
    Label extras = new Label("Extras (Select up to 2): ");

    Label total = new Label("Total: 0");

    double result = 0;

    CheckBox eightGigs = new CheckBox("8 gigabytes per month: $45.00 " +
            "per month");
    CheckBox sixteenGigs = new CheckBox("16 gigabytes per month: " +
            "$65.00 per month");
    CheckBox twentyBox = new CheckBox("20 gigabytes per month: $99.00 " +
            "per month");

    CheckBox modelOne = new CheckBox("Model 100: $299.95");
    CheckBox modelTwo = new CheckBox("Model 110: $399.95");
    CheckBox modelThree = new CheckBox("Model 200: $499.95");

    CheckBox insurance = new CheckBox("Insurance: $5.00 per month");
    CheckBox wifi = new CheckBox("Wifi Hotspot Capability: $10.00 per " +
            "month");

    @Override
    public void start(Stage primaryStage) throws Exception{
        eightGigs.selectedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if(newValue) {
                    result += 45;
                    total.setText("Total: " + result);
                    sixteenGigs.setAllowIndeterminate(true);
                    twentyBox.setAllowIndeterminate(true);
                }else{
                    result -= 45;
                    total.setText("Total: " + result);
                    sixteenGigs.setAllowIndeterminate(false);
                    twentyBox.setAllowIndeterminate(false);
                }
            }
        });
        sixteenGigs.selectedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if(newValue) {
                    result += 65;
                    total.setText("Total: " + result);
                    eightGigs.setAllowIndeterminate(true);
                    twentyBox.setAllowIndeterminate(true);
                }else{
                    result -= 65;
                    total.setText("Total: " + result);
                    eightGigs.setAllowIndeterminate(false);
                    twentyBox.setAllowIndeterminate(false);
                }
            }
        });
        twentyBox.selectedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if(newValue) {
                    result += 99;
                    total.setText("Total: " + result);
                    eightGigs.setAllowIndeterminate(true);
                    sixteenGigs.setAllowIndeterminate(true);
                }else{
                    result -= 99;
                    total.setText("Total: " + result);
                    eightGigs.setAllowIndeterminate(false);
                    sixteenGigs.setAllowIndeterminate(false);
                }
            }
        });
        modelOne.selectedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if(newValue) {
                    result += 299.95;
                    total.setText("Total: " + result);
                    modelTwo.setAllowIndeterminate(true);
                    modelThree.setAllowIndeterminate(true);
                } else {
                    result -= 299.95;
                    total.setText("Total: " + result);
                    modelTwo.setAllowIndeterminate(false);
                    modelThree.setAllowIndeterminate(false);
                }
            }
        });
        modelTwo.selectedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if(newValue) {
                    result += 399.95;
                    total.setText("Total: " + result);
                    modelOne.setAllowIndeterminate(true);
                    modelThree.setAllowIndeterminate(true);
                } else {
                    result -= 399.95;
                    total.setText("Total: " + result);
                    modelOne.setAllowIndeterminate(false);
                    modelThree.setAllowIndeterminate(false);
                }
            }
        });
        modelThree.selectedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if(newValue) {
                    result += 499.95;
                    total.setText("Total: " + result);
                    modelTwo.setAllowIndeterminate(true);
                    modelOne.setAllowIndeterminate(true);
                } else {
                    result -= 499.95;
                    total.setText("Total: " + result);
                    modelTwo.setAllowIndeterminate(false);
                    modelOne.setAllowIndeterminate(false);
                }
            }
        });
        insurance.selectedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if(newValue) {
                    result += 5;
                    total.setText("Total: " + result);
                } else {
                    result -= 5;
                    total.setText("Total: " + result);
                }
            }
        });
        wifi.selectedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if(newValue) {
                    result += 10;
                    total.setText("Total: " + result);
                } else {
                    result -= 10;
                    total.setText("Total: " + result);
                }
            }
        });

        VBox vBoxLabel = new VBox(10, dataPlan, eightGigs, sixteenGigs,
                twentyBox, phones, modelOne, modelTwo, modelThree, extras,
                insurance, wifi);
        vBoxLabel.setPadding(new Insets(25));

        HBox hBoxLabel = new HBox(10, total);
        hBoxLabel.setPadding(new Insets(25));

        GridPane gridPaneLabel = new GridPane();
        gridPaneLabel.add(vBoxLabel, 0, 0);
        gridPaneLabel.add(hBoxLabel, 0, 1);

        primaryStage.setTitle("In Class 8");
        primaryStage.setScene(new Scene(gridPaneLabel));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
