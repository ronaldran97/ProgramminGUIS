package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.*;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;


public class Main extends Application {

  //textfields
  TextField numDayText = new TextField();
  TextField fareText = new TextField();
  //TextField mileText = new TextField();
  TextField regText = new TextField();
  TextField lodgetext = new TextField();
  TextField foodText = new TextField();

  //choice box
  ChoiceBox<String> choiceBox = new ChoiceBox<>();
  String travels;
  double fareDriving = 0.0;

  //Labels
  Label numDaysLabel = new Label("Number of Travel Days: ");
  Label transLabel = new Label("Transportation: ");  //transportation
  Label fareLabel = new Label("Miles or Airfare: ");      //miles or airfare
  Label regLabel = new Label("Registration Cost: ");
  Label lodgingLabel = new Label("Lodging Cost per Day: ");
  Label foodLabel = new Label("Food Cost per Day: ");
  Label totalOutcomelabel = new Label("Total: ");
  Label totalReimbLabel = new Label("Total Reimbursements: ");
  Label finalResult = new Label("Total Due: ");  //final total

  Label totalOutcomelabelPr = new Label("0");
  Label totalReimbLabelPr = new Label("0");
  Label finalResultPr = new Label("0");  //final total


  //Double total = 0.0;
  //Double reim = 0.0;

  Double foodTotal = 0.0;
  Double lodgeTotal = 0.0;
//  Double miletotal = 0.0;
//  Double planeCost = 0.0;
  Double regCost = 0.0;


  @Override
  public void start(Stage primaryStage) throws Exception{
    primaryStage.setTitle("Trip Expenses");

    choiceBox.getItems().add("Plane");
    choiceBox.getItems().add("Car");

    GridPane gridPane = new GridPane();

    //Formatting
    VBox vboxLabel = new VBox(20, numDaysLabel, transLabel, fareLabel,
            regLabel, lodgingLabel, foodLabel);
    vboxLabel.setAlignment(Pos.TOP_RIGHT);
    gridPane.add(vboxLabel,1,0);

    VBox vboxText = new VBox(10,numDayText, choiceBox, fareText
            /*mileText*/, regText, lodgetext, foodText);

    gridPane.add(vboxText,2,0);


    gridPane.add(totalOutcomelabel, 1, 1);
    totalOutcomelabel.setAlignment(Pos.BASELINE_CENTER);
    gridPane.add(totalReimbLabel, 1, 2);
    totalReimbLabel.setAlignment(Pos.BASELINE_CENTER);
    gridPane.add(finalResult, 1, 3);
    finalResult.setAlignment(Pos.BASELINE_CENTER);

    gridPane.add(totalOutcomelabelPr, 2, 1);
    totalOutcomelabelPr.setAlignment(Pos.BASELINE_CENTER);
    gridPane.add(totalReimbLabelPr, 2, 2);
    totalReimbLabelPr.setAlignment(Pos.BASELINE_CENTER);
    gridPane.add(finalResultPr, 2, 3);
    finalResultPr.setAlignment(Pos.BASELINE_CENTER);





//    VBox resultBox = new VBox(10, resultLabel1, resultLabel2);
//    gridPane.add(resultBox, 2, 0);

    //buttons
    Button submit = new Button("Submit");
    Button cancelButton = new Button("Cancel");

    //cancel button
    cancelButton.setCancelButton(true);
    //setOnAction register an instance of ButtonClickHandler to this button
    cancelButton.setOnAction(e -> {
      System.out.println("Cancel clicked."); //check the cancel button
      primaryStage.close(); //closes window
    });

    submit.setOnAction(new ButtonHandlerSubmit());

    //grid for submit and cancel button
    GridPane buttonGrid = new GridPane();

    //Text and labels being formatted
    buttonGrid.add(submit, 0, 0);
    buttonGrid.add(cancelButton, 2, 0);
    buttonGrid.setAlignment(Pos.CENTER);
    buttonGrid.setPadding( new Insets(10));
    buttonGrid.setHgap(30);
    buttonGrid.setVgap(10);

    gridPane.setAlignment(Pos.CENTER);
    gridPane.setPadding( new Insets(10));
    gridPane.setHgap(10);
    gridPane.setVgap(10);

    //Vbox b is holding everything and b is in the scene
    VBox b = new VBox(10,gridPane,buttonGrid);
    Scene scene = new Scene(b);

    //show gridlines, for debugging
//    gridPane.setGridLinesVisible(true);
//    buttonGrid.setGridLinesVisible(true);


    //validation
    numDayText.textProperty().addListener(new ChangeListener<String>() {
      @Override
      public void changed(ObservableValue<? extends String> see, String oVal, String nVal) {
        if (!nVal.matches("\\d{0,7}([\\.]\\d{0,4})?")) {
          numDayText.setText(oVal);
        }
      }
    });
    fareText.textProperty().addListener(new ChangeListener<String>() {
      @Override
      public void changed(ObservableValue<? extends String> see, String oVal, String nVal) {
        if (!nVal.matches("\\d{0,7}([\\.]\\d{0,4})?")) {
          fareText.setText(oVal);
        }
      }
    });
    regText.textProperty().addListener(new ChangeListener<String>() {
      @Override
      public void changed(ObservableValue<? extends String> see, String oVal, String nVal) {
        if (!nVal.matches("\\d{0,7}([\\.]\\d{0,4})?")) {
          regText.setText(oVal);
        }
      }
    });
    lodgetext.textProperty().addListener(new ChangeListener<String>() {
      @Override
      public void changed(ObservableValue<? extends String> see, String oVal, String nVal) {
        if (!nVal.matches("\\d{0,7}([\\.]\\d{0,4})?")) {
          lodgetext.setText(oVal);
        }
      }
    });
    foodText.textProperty().addListener(new ChangeListener<String>() {
      @Override
      public void changed(ObservableValue<? extends String> see, String oVal, String nVal) {
        if (!nVal.matches("\\d{0,7}([\\.]\\d{0,4})?")) {
          foodText.setText(oVal);
        }
      }
    });

    primaryStage.setScene(scene);
    primaryStage.show(); //shows the stage
    }

  class ButtonHandlerSubmit implements EventHandler<ActionEvent> {

    @Override
    public void handle(ActionEvent event) {

      //input
      double numDay = Double.parseDouble(numDayText.getText());
      double fare = Double.parseDouble(fareText.getText()); //cost
      //double miles = Double.parseDouble(mileText.getText());
      regCost = Double.parseDouble(regText.getText());
      double lodge = Double.parseDouble(lodgetext.getText());
      double food = Double.parseDouble(foodText.getText());

      //before
      double total = fare + regCost + (lodge * numDay) + food;
      //total expenses before reimbursement
      totalOutcomelabelPr.setText(String.format("$ %.2f \n", total)); //total

      //fare stuff
      travels = choiceBox.getSelectionModel().getSelectedItem();
      if (travels == "Car"){
        fareDriving = fare * .42;
        fare = fareDriving;
      }
      if(travels == "Plane"){
        fare = 0.0;
      }

      //food
      if ((food - (numDay*47)) < 0) {
        food = 0.0;
      } else {
        foodTotal = (food - (numDay*47));
        food = foodTotal;
      }

      //check if lodging costs less than $195 a day
      if (((lodge*numDay) - (numDay*195)) < 0) {
        numDay = 0.0;
      } else {
        lodgeTotal = ((lodge * numDay) - (numDay * 195));
        lodge = lodgeTotal;
      }

      //after
      double reimTotal = fare + regCost + (lodge) + food;

      totalReimbLabelPr.setText(String.format("$ %.2f \n", reimTotal));
      finalResultPr.setText(String.format("$ %.2f ", (total - reimTotal)));

      //display results
      totalReimbLabelPr.setText(String.format("$ %,.2f ", total));
      totalReimbLabelPr.setText(String.format("$ %,.2f ", reimTotal));
      System.out.println(total);

    }

  }

  public static void main(String[] args) {
    launch(args); //launch from application
  }

}
