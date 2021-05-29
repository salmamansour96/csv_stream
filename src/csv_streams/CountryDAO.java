package csv_streams;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;




public class CountryDAO {
	
	public List<Country> readcsv(String path) throws FileNotFoundException  {
		BufferedReader br=new BufferedReader(new FileReader(path));
		String line="";
		List<Country> p_list=new LinkedList<Country>();
		try {
			 line=br.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		do
		{   try {
			line=br.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			if(line!=null)
			{
			//System.out.println("Line After reading"+"  "+line);
			String [] parts=line.split(",");
			p_list.add(new Country (parts[0].trim(),parts[1],parts[2],Double.parseDouble(parts[4]),Integer.parseInt(parts[3]),Double.parseDouble(parts[5]),Integer.parseInt(parts[6])));
				
			
		}}while(line!=null);
		
	return p_list;   	
	}
	public Map<String, List<City>> build_country_Map(List<City> cities){
		Map<String , List<City>> country_cities = new HashMap<String, List<City>>();
		for(City city :cities) {
			
			if(country_cities.containsKey(city.getCountry_code())) {
				country_cities.get(city.getCountry_code()).add(city);
			}
			else
			{
				country_cities.put(city.getCountry_code(), new ArrayList<City>());
				country_cities.get(city.getCountry_code()).add(city);

			}
		
		}
		return country_cities;
	}
	public  void sort_cities(Map<String , List<City>> country_cities, String code) {
		if(country_cities.containsKey(code)) {
			country_cities.get(code).sort((c,t)->c.getPopulation()
					> t.getPopulation()? 1:-1);

		}
		else {
			System.out.println("noooooooo cities for code");
		}
	}

}
