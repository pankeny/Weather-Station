package pl.mkon.weatherstation.view;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import pl.mkon.weatherstation.MainApp;
import pl.mkon.weatherstation.model.WeatherConditions;

public class WeatherDisplayController {
	
	@FXML
	private Label cityNameLabel;
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
	@FXML
	private TextField cityNameTextField;
	
	private MainApp mainApp;
	
	@FXML
	private void initialize() {
		
		showWeatherConditions(null);
	}
	
	@FXML
	private void handleCheckTheWeather() {
		if (cityNameLabel.getText().length() != 0) {
			WeatherConditions city = new WeatherConditions(cityNameLabel.getText());
			showWeatherConditions(city);
		} else {
	        Alert alert = new Alert(AlertType.WARNING);
	        alert.initOwner(mainApp.getPrimaryStage());
	        alert.setTitle("Empty field");
	        alert.setHeaderText("No city typed in text field");
	        alert.setContentText("Please type city name to chech current weather.");

	        alert.showAndWait();
		}
	}
	
	
	public WeatherDisplayController() {
		
	}
	
	public void setMainApp(MainApp mainApp)
	{
		this.mainApp = mainApp;
	}
	
	private void showWeatherConditions(WeatherConditions city)
	{
		if (city != null) {
			cityNameLabel.setText("Weather for " + city.getCityName());
			temperatureLabel.setText((new String()).valueOf(city.getTemperature()));
			cloudsLabel.setText((new String()).valueOf(city.getClouds()));
			humidityLabel.setText((new String()).valueOf(city.getHumidity()));
			windSpeedLabel.setText((new String()).valueOf(city.getWindSpeed()));
			pressureLabel.setText((new String()).valueOf(city.getPressure()));
		} else {
			cityNameLabel.setText("");
			temperatureLabel.setText("");
			cloudsLabel.setText("");
			humidityLabel.setText("");
			windSpeedLabel.setText("");
			pressureLabel.setText("");
		}
	}
	
}
