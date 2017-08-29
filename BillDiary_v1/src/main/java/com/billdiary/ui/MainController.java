package com.billdiary.ui;

import java.sql.SQLException;
import com.billdiary.dao.CreateSchema;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainController extends Application{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			CreateSchema.CreateDatabase();

		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		launch(args); 
		
	}

	@Override
	public void start(Stage stage) throws Exception {
		// TODO Auto-generated method stub
		
	      //Creating a scene object 
	      Scene scene =LoginController.getLoginStage(); 
	       
	      //Setting title to the Stage 
	      stage.setTitle("Bill Diary"); 
	         
	      //Adding scene to the stage 
	      stage.setScene(scene);
	      
	      //Displaying the contents of the stage 
	      stage.show(); 
		
	}
	
	
}
