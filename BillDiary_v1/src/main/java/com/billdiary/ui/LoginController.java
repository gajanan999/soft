package com.billdiary.ui;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;


public class LoginController {

	public static Scene getLoginStage()
	{
		//creating label email 
	      Text text1 = new Text("UserID");       
	      
	      //creating label password 
	      Text text2 = new Text("Password"); 
	       
	      //Creating Text Filed for email        
	      TextField textField1 = new TextField();       
	      
	      //Creating Text Filed for password        
	      PasswordField textField2 = new PasswordField();  
	       
	      //for showing database data
	      TextField textField3 = new TextField(); 
	      
	      
	      //Creating Buttons 
	      Button button1 = new Button("Submit"); 
	      
	      button1.setOnAction(new EventHandler<ActionEvent>() {
	            @Override
	            public void handle(ActionEvent event) {
	                System.out.println("Hello World!");
	                Connection connection=null;
	                PreparedStatement st=null;
	                ResultSet r1=null;
	                String g=null;
	                try {
						Class.forName("org.hsqldb.jdbc.JDBCDriver");
						 connection = DriverManager.getConnection("jdbc:hsqldb:billdiarydb", "gajanan", "gajanan");
		        		 st = connection.prepareStatement("select * from user");
		        		 r1=st.executeQuery();
		        		 while(r1.next())
		        		 {
		        			   System.out.println(r1.getInt(1)+" "+r1.getString(2));
		        			   g=String.valueOf(r1.getInt(1))+" "+r1.getString(2);
		        		 }
		        		 textField3.setText(g);
						
						
					} catch (ClassNotFoundException | SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	                finally {
	                	try {
							r1.close();
							st.close();
		            		connection.close();
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
	            		
	                }
	        
	        		
	        		
	                
	            }
	        });
	      
	      
	      
	      
	      
	      Button button2 = new Button("Clear");  
	      
	      //Creating a Grid Pane 
	      GridPane gridPane = new GridPane();    
	      
	      //Setting size for the pane 
	      gridPane.setMinSize(400, 200); 
	      
	      //Setting the padding  
	      gridPane.setPadding(new Insets(10, 10, 10, 10)); 
	      
	      //Setting the vertical and horizontal gaps between the columns 
	      gridPane.setVgap(5); 
	      gridPane.setHgap(5);       
	      
	      //Setting the Grid alignment 
	      gridPane.setAlignment(Pos.CENTER); 
	       
	      //Arranging all the nodes in the grid 
	      gridPane.add(text1, 0, 0); 
	      gridPane.add(textField1, 1, 0); 
	      gridPane.add(text2, 0, 1);       
	      gridPane.add(textField2, 1, 1); 
	      gridPane.add(button1, 0, 2); 
	      gridPane.add(button2, 1, 2); 
	      gridPane.add(textField3, 1, 3);
	       
	      //Styling nodes  
	      button1.setStyle("-fx-background-color: darkslateblue; -fx-text-fill: white;"); 
	      button2.setStyle("-fx-background-color: darkslateblue; -fx-text-fill: white;"); 
	       
	      text1.setStyle("-fx-font: normal bold 20px 'serif' "); 
	      text2.setStyle("-fx-font: normal bold 20px 'serif' ");  
	      gridPane.setStyle("-fx-background-color: BEIGE;"); 
	       
		
		
		 
	      
	      Scene scene = new Scene(gridPane);
	      return scene;
	}
	
	
}
