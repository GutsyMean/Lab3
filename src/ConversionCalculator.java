import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class ConversionCalculator extends Application
{
	public static void main(String[] args)
	{	// Launch the application.
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage)
	{	
		
		// Set stage title
		primaryStage.setTitle("Conversion Calculator");
		
		primaryStage.show();
	}

}
