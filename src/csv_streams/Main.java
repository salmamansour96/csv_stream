
package csv_streams;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.IntSummaryStatistics;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

	public static void main(String[] args) {
		List<City> cities=new LinkedList<City>();
		CityDAO city1=new CityDAO();
		try {
			 cities=city1.readcsv("E:\\linux course\\java\\Java & UML Programming\\CSV_files\\CSV_files\\Cities.csv");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		List<Country> countries=new LinkedList<Country>();
		
		CountryDAO countrydoa=new CountryDAO();
		try {
			countries=countrydoa.readcsv("E:\\linux course\\java\\Java & UML Programming\\CSV_files\\CSV_files\\Countries.csv");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		//get list of countries population
		List<Integer> countries_population=countries.stream().filter(c->c.getPopulation()>0).map(Country::getPopulation).collect(Collectors.toList());
		
	   IntSummaryStatistics Countries_list_stat=countries_population.stream().mapToInt(Integer::intValue).summaryStatistics();	
	
	    System.out.printf("Average: %.2f%n", Countries_list_stat.getAverage());
	    
	   //get the max of countries populations 
	    System.out.printf("Max: %d%n", Countries_list_stat.getMax());
 
		
/////////////
////		// TODO Auto-generated method stub
////		List<Country> countries = null;
////		List<City> cities = null;
//		CountryDAO countryDAO = new CountryDAO();
//		CityDAO cityDAO = new CityDAO();
//		try {
//			countries = countryDAO.readcsv("G:\\exported data\\iti\\Java & UML Programming\\Countries.csv");
//			cities = cityDAO.readcsv("G:\\exported data\\iti\\Java & UML Programming\\Cities.csv");
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	    BufferedReader reader = new BufferedReader(
	            new InputStreamReader(System.in));
	    String console = null;
	 
	        // Reading data using readLine
	        try {
				console = reader.readLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		Map<String, List<City>> country_cities = countrydoa.build_country_Map(cities);
		
		countrydoa.sort_cities(country_cities, console);
	
			for(City city: country_cities.get(console)) {
					System.out.println("country code:"+console+"  "+city.getPopulation());
			}
		
		
		Map<String, City> country_city_high_pop = CountryStreams.hightest_pop_City(country_cities);
		for(String key:country_city_high_pop.keySet()) {
			System.out.println("city name"+country_city_high_pop.get(key).getName()+
					" "+country_city_high_pop.get(key).getPopulation());
		}
		City hightcpital_pop = CountryStreams.hightest_pop_capital(countries, cities); 
		System.out.println("the hightest pop capital is"+hightcpital_pop); 
		
		  
      
	}

}
