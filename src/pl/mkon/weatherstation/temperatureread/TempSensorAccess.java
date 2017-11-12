package pl.mkon.weatherstation.temperatureread;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.text.ParseException;

import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

public class TempSensorAccess {
	
	private String cityName;
	private String url;
	
	public TempSensorAccess(String cityName)
	{
		this.cityName = cityName;
		this.setURL(cityName);
	}
	
	public void setURL(String name)
	{
		this.url = "http://api.openweathermap.org/data/2.5/weather?q=" + name + "&APPID=af319cd969dff7d8c42768f6f0d8c979&units=metric";
	}
	
	public long getTemp()
	{

		long temp = 0;
		try {
			JSONObject json = new JSONObject(readUrl(this.url));
			temp = (long) json.get("temp");
			return temp;
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}  catch (Exception e) {
			e.printStackTrace();
		}
		
		return -505;
	}
	
	public static JSONObject readUrl(String urlString) throws Exception
	{
		BufferedReader reader = null;
		JSONObject json;
		
		try {
			URL url = new URL(urlString);
			reader = new BufferedReader(new InputStreamReader(url.openStream()));
			StringBuffer buffer = new StringBuffer();
			int read;
			char[] chars = new char[1024];
			while ( (read = reader.read(chars)) != -1) {
				buffer.append(chars, 0, read);
			}
			json = (JSONObject) JSONValue.parseWithException(buffer.toString());
			return (JSONObject) json.get("main");
		} finally {
			if (reader != null) {
				reader.close();
			}
		}
	}
	
	public String showTemp()
	{
		return new String("Temperatura w miescie " + this.cityName + " wynosi: " + this.getTemp() );
	}
	
}
