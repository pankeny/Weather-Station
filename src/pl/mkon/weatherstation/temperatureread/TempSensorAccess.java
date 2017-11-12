package pl.mkon.weatherstation.temperatureread;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

import org.json.JSONObject;

import netscape.javascript.JSException;

public class TempSensorAccess {
	
	private String url;
	
	public TempSensorAccess(String cityName)
	{
		this.setURL(cityName);
	}
	
	public void setURL(String name)
	{
		this.url = "http://api.openweathermap.org/data/2.5/weather?q=" + name + "&APPID=af319cd969dff7d8c42768f6f0d8c979&units=metric";
	}
	
	public String getTemp() throws Exception
	{
			
		try {
			JSONObject json = new JSONObject(readUrl(this.url));
			return (String) json.get("main.temp");
		}catch (JSException e) {
			e.printStackTrace();
		}
		
		return null;
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
	
}
