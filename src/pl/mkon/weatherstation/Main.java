package pl.mkon.weatherstation;

import java.util.Scanner;

import pl.mkon.weatherstation.model.WeatherConditions;

public class Main {

	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		
		
		System.out.print("Podaj miasto dla którego chcesz odczytać bieżącą temperature: ");
		WeatherConditions city = new WeatherConditions(in.nextLine());
		System.out.println(city.toString());
		
		in.close();
	}

}
