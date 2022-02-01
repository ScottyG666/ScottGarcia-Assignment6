package assignment6.main.teslasalesreportbymodel;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import assignment6.main.POJOs.MonthYearSales;
import assignment6.main.services.SalesReportSortingService;

public class TeslaSalesReportByModel {

	private String designationOfModel ;
	public String getDesignationOfModel() {
		return designationOfModel;
	}

	private MonthYearSales worstMonth;
	public MonthYearSales getWorstMonth() {
		return worstMonth;
	}

	private MonthYearSales bestMonth;
	public MonthYearSales getBestMonth() {
		return bestMonth;
	}
	
	
	private Map<Integer, List<MonthYearSales>> listOfMonthsForInstantiatedYear;
	public Map<Integer, List<MonthYearSales>> getListOfMonthsForInstantiatedYear() {
		return listOfMonthsForInstantiatedYear;
	}

	
	public TeslaSalesReportByModel(String filePath) {
		
		this.designationOfModel = filePath.split("\\.")[0].substring(5);

		SalesReportSortingService sorter = new SalesReportSortingService();

		this.listOfMonthsForInstantiatedYear = sorter.convertCSVToListOfSortedYears(filePath);
		
		this.worstMonth = sorter.getWorstMonth(filePath);
		
		this.bestMonth = sorter.getBestMonth(filePath);

	}

	public void printSalesReport() {
		
		System.out.println("Model " + this.getDesignationOfModel() + " Yearly Sales Report");

		System.out.println("-----------------------");

		Set<Entry<Integer, List<MonthYearSales>>> entrySetOfSalesSeperatedByYear = this.getListOfMonthsForInstantiatedYear().entrySet();

		entrySetOfSalesSeperatedByYear.stream()
									  .forEach(list -> {
										  String yearTheseSalesAreFor = list.getKey().toString();
										  
										  Integer salesForTheYear = list.getValue().stream()
												  								   .mapToInt(o -> o.getSalesForTheMonth())
												  								   .sum();
										  
										  System.out.println(yearTheseSalesAreFor + " -> " + String.valueOf(salesForTheYear)) ;
										  				 
										  
									  });
		System.out.println("");
		System.out.println("The best Month For Model " + this.getDesignationOfModel() +  " was: " + this.getBestMonth());
		System.out.println("The worst Month For Model " + this.getDesignationOfModel() +  " was: " + this.getWorstMonth());
		System.out.println("\n");
		
	}

}
