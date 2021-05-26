package csv_streams;

public class Country {
	private String code;
	private String name;
	private String continent;
	private double area;
	private int population;
	private double gnp;
	private int capital;
  
	
	
	

	public Country(String code, String name, String continent, double area, int population, double gnp,
		int capital) {
		
		
		     this.code=code;
		   this.area=area;
		   this.capital=capital;
		   this.continent=continent;
		   this.gnp=gnp;
		   this.name=name;
		   this.population=population;
	// TODO Auto-generated constructor stub
}





	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContinent() {
		return continent;
	}

	public void setContinent(String continent) {
		this.continent = continent;
	}

	public double getArea() {
		return area;
	}

	public void setArea(double area) {
		this.area = area;
	}

	public int getPopulation() {
		return population;
	}

	public void setPopulation(int population) {
		this.population = population;
	}

	public double getGnp() {
		return gnp;
	}

	public void setGnp(double gnp) {
		this.gnp = gnp;
	}

	public int getCapital() {
		return capital;
	}

	public void setCapital(int capital) {
		this.capital = capital;
	}
	

}
