package assignment6.main.services;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import assignment6.main.POJOs.MonthYearSales;

public class FileReaderService {
	
	public List<MonthYearSales>  convertCSVFileToListOfMYSObjects (String filePath) {
		
		List<MonthYearSales> holderListForMYSObjects = new ArrayList<>();
		
		
		try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
			
			
			String line = reader.readLine() ;
			while((line = reader.readLine()) != null) {
				holderListForMYSObjects.add(new MonthYearSales(line));
			}
			
			
		} catch (FileNotFoundException e) {
			System.out.println("That file was not Found.");
		} catch (IOException e) {
			System.out.println("Whoops, you have an IO Exception.");
		}
		
		return holderListForMYSObjects;
		
	}
	
}
