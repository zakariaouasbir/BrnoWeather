package com.weather.brno.BrnoWeather.service;


import java.io.IOException;


import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;



public class HtmlCrawler     { 
	  
	  final static int FIRST_INDEX=13;
  
	
	  public static String getHtmlByUrl(String url) {
	      String strHTMLbody = new String("");
		  try{
			  //connect to the website
			  Connection connection = Jsoup.connect(url);
			  //set user agent to Google Chrome
			  connection.userAgent("Mozilla/5.0");
			  //set timeout to 10 seconds
			  connection.timeout(10 * 1000);
			  //get the HTML document
			  Document doc = connection.get();
		   	//parse text from HTML
			strHTMLbody = doc.html();
			// return Html as String
			  return strHTMLbody;
			  }catch(IOException ioe){
			      ioe.printStackTrace();
			  }finally {
				  return strHTMLbody;
			  	}
		
	  }
	  
	  public static String extractDivHtmlBySelector(String html) {
		  Document document = Jsoup.parse(html);
	      Element link = document.select("div.right").first();  
	          return link.html();
	  }
	  
	  public static String extractPHtmlBySelector(String html) {
		  Document document = Jsoup.parse(html);
	      Element link = document.select("p.panel-item").get(1);
	         return link.html();

	  }
	  
	  public static String extractSpanHtmlBySelector(String html) {
		  Document document = Jsoup.parse(html);
	      Element link = document.select("span.value").first();
	      	return  link.html();
	     }
	  
	  public static String getPrecipitaionString(String url) {
		  	String html =  getHtmlByUrl(url);
			String html1 = extractDivHtmlBySelector(html);
			String html2 = extractPHtmlBySelector(html1);
				return extractSpanHtmlBySelector(html2);
	  }
	  

		
		public static  Double getPrecipitationAsnumber(String precipetation){
				if( precipetation != null &&  precipetation.length() != 0 && !precipetation.substring(0, precipetation.length() - 3).equals(""))
					{
					String result = precipetation.substring(0, precipetation.length() - 3);
					return  new Double(result);
					}
				else return null;
		}
	  }