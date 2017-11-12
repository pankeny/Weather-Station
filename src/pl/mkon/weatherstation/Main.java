package pl.mkon.weatherstation;

import pl.mkon.weatherstation.temperatureread.TempSensorAccess;

public class Main {

	public static void main(String[] args) throws Exception {
		TempSensorAccess krakow = new TempSensorAccess("Krakow");
		System.out.println(krakow.getTemp());
	}

}
