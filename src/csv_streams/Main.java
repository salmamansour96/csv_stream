package csv_streams;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Country> countries = null;
		List<City> cities = null;
		CountryDAO countryDAO = new CountryDAO();
		CityDAO cityDAO = new CityDAO();
		try {
			countries = countryDAO.readcsv("G:\\exported data\\iti\\Java & UML Programming\\Countries.csv");
			cities = cityDAO.readcsv("G:\\exported data\\iti\\Java & UML Programming\\Cities.csv");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Map<String, List<City>> country_cities = countryDAO.build_country_Map(cities);
		
		countryDAO.sort_cities(country_cities, "ZAF");
		for(String key : country_cities.keySet()) {
			for(City city: country_cities.get(key)) {
				//if("ZAF".equals(key))
				//	System.out.println("country code:"+key+"  "+city.getPopulation());
			}
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
