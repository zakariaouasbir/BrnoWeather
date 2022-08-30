package com.weather.brno.BrnoWeather.service;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.OptionalDouble;

public class AveragePercipitation {
	   //DecimalFormat to keep only 2 decimales in the average 
    private static final DecimalFormat df = new DecimalFormat("0.00");

	public List<Double> list_precipitation_septembre;
	String week_days[]  = new String[] {
			"Thursday",
			"Friday",
			"Saturday",
			"Sunday",
 			"Monday",
			"Tuesday",
			"Wednesday"};
    
    
    public  AveragePercipitation() {
		this.list_precipitation_septembre  = new ArrayList<Double>();
	}

	 
	
	
	public List<Double> getList_precipitation_septembre() {
		return list_precipitation_septembre;
	}




	public void setList_precipitation_septembre(List<Double> list_precipitation_septembre) {
		this.list_precipitation_septembre = list_precipitation_septembre;
	}




	public void PrintCalendar() {
		//counter to print calendar 
		int i = 0;

		 List<String> dayslist =  Arrays.asList(week_days);
		 //Print days in header
		 for (String day : dayslist) {
			 System.out.print(day+"   ");
		 }
		 System.out.println("");
		//print value for each day
		for (Double val : list_precipitation_septembre) {
			i++;
				if(i!= 7)
					{
					
					System.out.print(val+"       ");
					}
				else
					{
					i = 0;
					System.out.print(val+"       ");
					System.out.println("");
					}
		}
		 System.out.println("");
	}




	@Override
	public String toString() {
		// variable to store average percipitation
		OptionalDouble average_precipitation = list_precipitation_septembre
				.stream()
	            .mapToDouble(a -> a)
	            .average();
		return "The average precipitation for Septembre is : "+df.format(average_precipitation.getAsDouble())+" mm";
	}

	
}
