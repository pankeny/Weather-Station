package pl.mkon.weatherstation.view;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import pl.mkon.weatherstation.MainApp;

public class WeatherDisplayController {
	
	@FXML
	private Label temperatureLabel;	
	@FXML
	private Label cloudsLabel;
	@FXML
	private Label humidityLabel;
	@FXML
	private Label windSpeedLabel;	
	@FXML
	private Label pressureLabel;
	
	private MainApp mainApp;
	
	public WeatherDisplayController() {
		
	}
	
	public void setMainApp(MainApp mainApp)
	{
		this.mainApp = mainApp;
	}
	
}
