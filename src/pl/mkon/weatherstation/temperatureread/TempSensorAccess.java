package pl.mkon.weatherstation.temperatureread;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

public class TempSensorAccess {
	private String name;
	private String url;
	
	public TempSensorAccess(String name)
	{
		this.name = name;
		this.setURL(name);
	}
	
	public void setURL(String name)
	{
		this.url = "http://api.openweathermap.org/data/2.5/weather?q=" + name + "&APPID=af319cd969dff7d8c42768f6f0d8c979&units=metric";
	}
	
	public int getTemp()
	{
		int temp = 0;
		
		try {
			JSON json;
		}catch () {
			
		}
		
		return temp;
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
