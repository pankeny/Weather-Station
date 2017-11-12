package pl.mkon.weatherstation;

import java.util.Scanner;

import pl.mkon.weatherstation.temperatureread.TempSensorAccess;

public class Main {

	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		TempSensorAccess krakow = new TempSensorAccess("Krakow");
		System.out.println("Przykładowy odczyt dla miasta Krakow\n" + krakow.showTemp());
		
		System.out.print("Podaj miasto dla którego chcesz odczytać bieżącą temperature: ");
		TempSensorAccess city = new TempSensorAccess(in.nextLine());
		System.out.println(city.showTemp());
		
		
	}

}
