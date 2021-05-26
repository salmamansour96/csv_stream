package csv_streams;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Map;

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
//		for(String key : country_cities.keySet()) {
//			for(City city: country_cities.get(key)) {
//				System.out.println("country code:"+key+"  "+city.getName());
//			}
//		}
      
	}

}
