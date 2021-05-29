package csv_streams;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class CityDAO {
	
	
	
	public List<City> readcsv(String path) throws FileNotFoundException  {
		BufferedReader br=new BufferedReader(new FileReader(path));
		String line="";
		List<City> p_list=new LinkedList<City>();
		
		
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
			
			
			
				
				p_list.add(new City (Integer.parseInt(parts[0]),Integer.parseInt(parts[2]),parts[1],parts[3].trim()));
				
			
		}}while(line!=null);
		
	return p_list;   	
	}


}
