package csv_streams;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;



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
			
			
			
				
				p_list.add(new Country (parts[0],parts[1],parts[2],Double.parseDouble(parts[4]),Integer.parseInt(parts[3]),Double.parseDouble(parts[5]),Integer.parseInt(parts[6])));
				
			
		}}while(line!=null);
		
	return p_list;   	
	}

}
