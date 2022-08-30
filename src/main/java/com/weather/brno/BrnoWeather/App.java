package com.weather.brno.BrnoWeather;



import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;

import com.weather.brno.BrnoWeather.service.AveragePercipitation;
import com.weather.brno.BrnoWeather.service.HtmlCrawler;



/**
 * Hello world!
 *
 */
public class App 
{
	// Url of the data provider website
	// Param ?day= should start with 4 for 01/09/2022
	// Param ?day= should end with 33 for 30/09/2022
    final  static String  URL_ACCUWEATHER = "https://www.accuweather.com/cs/cz/brno/123291/daily-weather-forecast/123291?day=";
 
    //
    private static AveragePercipitation averagePercipitation = new AveragePercipitation();
    // HtmlCrawler based on JSOUP Library
    private static HtmlCrawler crawler = new HtmlCrawler();

	    public static void main( String[] args ) throws Exception
	    { 		//List for storing percipitaion of each day
	    		List<Double> list_precipitation_septembre = new ArrayList<Double>();
	    		
	    		
	    		for (int i = 4; i < 34; i++) {
		    		//call html crawler to get Data for each day from 01/09 to 30/09
				    String res = crawler.getPrecipitaionString(URL_ACCUWEATHER+i);
				    //store result in percipitation List
					list_precipitation_septembre.add(crawler.getPrecipitationAsnumber(res));
				}
	    		//append list of values to the averagePercipitation object
	    		averagePercipitation.setList_precipitation_septembre(list_precipitation_septembre);
	    		//print values as calendar 
	    		averagePercipitation.PrintCalendar();
	    		
	    		//Print result
	    		System.out.println(averagePercipitation.toString());
	    		System.exit(0);
	    }
    
}