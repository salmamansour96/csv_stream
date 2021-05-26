package csv_streams;

public class City {

	private int id;
	private String name;
	private int population;
	private String Country_code;
	
    public City(int id,int population,String name,String country_code) {
    	this.id=id;
    	this.Country_code=country_code;
    	this.name=name;
    	this.population=population;
    	
    	
    }
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return getName() +" "+getPopulation() +" "+ getCountry_code();
	}
	public void setName(String name) {
		this.name = name;
	}

	public int getPopulation() {
		return population;
	}

	public void setPopulation(int population) {
		this.population = population;
	}

	public String getCountry_code() {
		return Country_code;
	}

	public void setCountry_code(String country_code) {
		Country_code = country_code;
	}
	
	
}
