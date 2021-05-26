package csv_streams;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CountryStreams {
	 public static Map<String, City> hightest_pop_City(Map<String, List<City>> country_cities) {
		 Map<String, City> country_pop = new HashMap<String, City>();
		 for(String key : country_cities.keySet()) {
			Optional<City> city =  country_cities.get(key).stream().max((m,t)->m.getPopulation()> t.getPopulation()?1:-1);
			country_pop.put(key,city.get()); 
			
		 }
		 return country_pop;
	}
	 public static City hightest_pop_capital(List<Country> countries ,List<City> cities) {
		 List<Integer> countries_capitals = countries.stream().map(m->m.getCapital()).collect(Collectors.toList());
		 return cities.stream().filter(t->countries_capitals.contains(t.getId())).max((c1,c2)->c1.getPopulation() >c2.getPopulation()?1:-1).get();
	}
 
}
