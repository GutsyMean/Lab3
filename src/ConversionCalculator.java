import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.scene.control.Alert;
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
		Label centimeterLabel = new Label("Centimeters:");
		TextField centimeterTXT = new TextField("0.0");
		
		Label meterLabel = new Label("Meters:");
		TextField meterTXT = new TextField("0.0");
		
		Label inchLabel = new Label("Inches:");
		TextField inchTXT = new TextField("0.0");
		
		Label yardLabel = new Label("Yards:");
		TextField yardTXT = new TextField("0.0");
		
		Button clearButton = new Button("Clear");
		Button calculateButton = new Button("Calculate");
		Button exitButton = new Button("Exit");
		clearButton.setPrefSize(80, 15);
		calculateButton.setPrefSize(80, 15);
		exitButton.setPrefSize(80, 15);
		
		HBox hbox1 = new HBox(1, centimeterLabel, centimeterTXT);
		HBox hbox2 = new HBox(1, meterLabel, meterTXT);
		HBox hbox3 = new HBox(1, inchLabel, inchTXT);
		HBox hbox4 = new HBox(1, yardLabel, yardTXT);

		VBox vbox1 = new VBox(20, hbox1, hbox2);
		VBox vbox2 = new VBox(20, hbox3, hbox4);
		VBox vbox3 = new VBox(clearButton, calculateButton, exitButton);
		
		HBox hbox = new HBox(30, vbox1, vbox2, vbox3);
		hbox.setPadding(new Insets(10));
		
		Scene scene = new Scene(hbox);

		
		clearButton.setOnAction(e -> 
		{
            centimeterTXT.setText("0.0");
            meterTXT.setText("0.0");
            inchTXT.setText("0.0");
            yardTXT.setText("0.0");
        });
		
		
		calculateButton.setOnAction(e ->
		{
			String centimetersStr = centimeterTXT.getText();
			String metersStr = meterTXT.getText();
			String inchesStr = inchTXT.getText();
			String yardsStr = yardTXT.getText();
			
			double centimeters = Double.parseDouble(centimetersStr.equals("") ? "0.0" : centimetersStr);
			double meters = Double.parseDouble(metersStr.equals("") ? "0.0" : metersStr);
			double inches = Double.parseDouble(inchesStr.equals("") ? "0.0" : inchesStr);
			double yards = Double.parseDouble(yardsStr.equals("") ? "0.0" : yardsStr);
			
			
			if (centimeters != 0) 
			{
			    meters = centimeters / 100;
			    inches = centimeters / 2.54;
			    yards = inches / 36;
			}
			else if (meters != 0) 
			{
			    centimeters = meters * 100;
			    inches = centimeters / 2.54;
			    yards = inches / 36;
			}
			else if (inches != 0) 
			{
			    centimeters = inches * 2.54;
			    meters = centimeters / 100;
			    yards = inches / 36;
			}
			else if (yards != 0) 
			{
			    inches = yards * 36;
			    centimeters = inches * 2.54;
			    meters = centimeters / 100;
			}
			
			centimeterTXT.setText(String.format("%.2f", centimeters));
			meterTXT.setText(String.format("%.2f", meters));
			inchTXT.setText(String.format("%.2f", inches));
			yardTXT.setText(String.format("%.2f", yards));
        });


		exitButton.setOnAction(e -> 
		{
			primaryStage.close();
		});
		
		
		primaryStage.setScene(scene);
		primaryStage.setTitle("Conversion Calculator");
		primaryStage.show();
	}
}
