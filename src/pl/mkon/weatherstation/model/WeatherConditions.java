package pl.mkon.weatherstation.model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.text.ParseException;

import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

public class WeatherConditions {
	
	private final String DEGREE  = "\u2103";
	
	String cityName;
	Long temperature;
	Long clouds;
	Long humidity;
	Double windSpeed;
	Long pressure;
	String url;
	
	public WeatherConditions() {
		
	}
	
	public WeatherConditions(String cityName) {
		this.cityName = cityName;
		
		setURL(cityName);
		setTemperature();
		setClouds();
		setHumidity();
		setWindSpeed();
		setPressure();
		
	}
	
	private void setURL(String cityName)
	{
		this.url = "http://api.openweathermap.org/data/2.5/weather?q=" + cityName + "&APPID=af319cd969dff7d8c42768f6f0d8c979&units=metric";
	}
	
	private void setTemperature() {
		JSONObject main;

		try {
			main = (JSONObject) (new JSONObject( (JSONObject) (JSONValue.parseWithException(readUrl(this.url))) ).get("main"));
			this.temperature = (Long) main.get("temp");
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}  catch (Exception e) {
			e.printStackTrace();
		}	
	}
	
	private void setClouds() {
		JSONObject clouds;

		try {
			clouds = (JSONObject) (new JSONObject( (JSONObject) (JSONValue.parseWithException(readUrl(this.url))) ).get("clouds"));
			this.clouds = (Long) clouds.get("all");
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}  catch (Exception e) {
			e.printStackTrace();
		}	
	}
	
	private void setHumidity() {
		JSONObject main;

		try {
			main = (JSONObject) (new JSONObject( (JSONObject) (JSONValue.parseWithException(readUrl(this.url))) ).get("main"));
			this.humidity = (Long) main.get("humidity");
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}  catch (Exception e) {
			e.printStackTrace();
		}	
	}
	
	
	private void setWindSpeed() {
		JSONObject wind;

		try {
			wind = (JSONObject) (new JSONObject( (JSONObject) (JSONValue.parseWithException(readUrl(this.url))) ).get("wind"));
			this.windSpeed = (Double) wind.get("speed");
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}  catch (Exception e) {
			e.printStackTrace();
		}	
	}
	
	private void setPressure() {
		JSONObject main;

		try {
			main = (JSONObject) (new JSONObject( (JSONObject) (JSONValue.parseWithException(readUrl(this.url))) ).get("main"));
			this.pressure = (Long) main.get("pressure");
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}  catch (Exception e) {
			e.printStackTrace();
		}	
	}
		
	

	
	private static String readUrl(String urlString) throws Exception
	{
		BufferedReader reader = null;
		
		try {
			URL url = new URL(urlString);
			reader = new BufferedReader(new InputStreamReader(url.openStream()));
			StringBuffer buffer = new StringBuffer();
			int read;
			char[] chars = new char[1024];
			while ( (read = reader.read(chars)) != -1) {
				buffer.append(chars, 0, read);
			}
			
			return buffer.toString();
		} finally {
			if (reader != null) {
				reader.close();
			}
		}
	}
	
	
	
	public String getCityName() {
		return cityName;
	}

	public Long getTemperature() {
		return temperature;
	}

	public Long getClouds() {
		return clouds;
	}

	public Long getHumidity() {
		return humidity;
	}

	public Double getWindSpeed() {
		return windSpeed;
	}

	public Long getPressure() {
		return pressure;
	}

	@Override
	public String toString()
	{
		return "Weather data for " + cityName + 
				"\nAir temperature: " + this.temperature + DEGREE +
				"\nCloudines: " + this.clouds + "%" +
				"\nHumidity: " + this.humidity + "%" +
				"\nWind speed: " + this.windSpeed + "m/s" +
				"\nPressure: " + this.pressure + "hPa";
	}
}

	

