package com.miu.edu.cs.mpp.assignment.Lab6Prob2;

import java.util.Optional;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {

    /**
     *
     */
    @Override
    public void start(Stage stage) {
      
    	GridPane gridPane = new GridPane();
    	
    	VBox vb1 = new VBox(10);
    	Button countBtn = new Button("Count Letters");
    	countBtn.setMaxWidth(Double.MAX_VALUE);
    	Button reverseBtn = new Button("Reverse Letter");
    	reverseBtn.setMaxWidth(Double.MAX_VALUE);
    	Button dupBtn = new Button("Remove dup");
    	dupBtn.setMaxWidth(Double.MAX_VALUE);
    	vb1.getChildren().addAll(countBtn, reverseBtn, dupBtn);
    	VBox vb2 = new VBox();
    	Label inputLabel = new Label("Input");
    	TextField inputField = new TextField();
    	Label outputLabel = new Label("Output");
    	TextField outField = new TextField();
    	vb2.getChildren().addAll(inputLabel, inputField, outputLabel, outField);
    	
    	gridPane.add(vb1, 0, 0);
    	gridPane.add(vb2, 1, 0);
    	
    	gridPane.setPadding(new Insets(20, 10, 10, 20)); 
    	
    	gridPane.setHgap(10); 
    	
    	ColumnConstraints column1 = new ColumnConstraints();
        column1.setHalignment(HPos.CENTER);
        column1.setPercentWidth(50);
        gridPane.getColumnConstraints().addAll(column1, column1); 
        
        RowConstraints row1 = new RowConstraints();
    	row1.setValignment(VPos.CENTER);
    	gridPane.getRowConstraints().add(row1);
        
        var scene = new Scene(gridPane);
        stage.setScene(scene);
        stage.show();
        
        countBtn.setOnAction(v->{
        	Integer counts = null;
        	String input = inputField.getText().trim().replace(" " , "");
        	boolean isNumber = true;
        	try {
        		Double.parseDouble(input);
        	}catch(NumberFormatException e) {
        		isNumber = false;
        	}
        	if(!isNumber) {
        		counts = 0;
        		for(int i=0; i< input.toCharArray().length; i++) {
            		counts ++;
            	}
        	}        	
        	outField.setText(Optional.ofNullable(counts).map(count-> String.valueOf(count)).orElse("Invalid Input"));
        });
        
        reverseBtn.setOnAction(v->{
        	String input = inputField.getText().trim().replace(" " , "");
        	String reverse = "";
        	for(char c: input.toCharArray()) {
        		reverse=c+reverse;
        	}
        	outField.setText(reverse);
        });
        
        dupBtn.setOnAction(v->{
        	String input = inputField.getText().trim().replace(" " , "");
        	StringBuilder sb = new StringBuilder();
        	input.chars().distinct().forEach(c -> sb.append((char) c));
        	outField.setText(sb.toString());
        });
    }

    public static void main(String[] args) {
        launch();
    }

}