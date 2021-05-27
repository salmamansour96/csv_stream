package csv_streams;

import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import java.util.IntSummaryStatistics;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<City> cities=new LinkedList<City>();
		CityDAO city1=new CityDAO();
		try {
			 cities=city1.readcsv("E:\\linux course\\java\\Java & UML Programming\\CSV_files\\CSV_files\\Cities.csv");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		List<Country> countries=new LinkedList<Country>();
		
		CountryDAO country1=new CountryDAO();
		try {
			countries=country1.readcsv("E:\\linux course\\java\\Java & UML Programming\\CSV_files\\CSV_files\\Countries.csv");
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
 
		

	}

}
