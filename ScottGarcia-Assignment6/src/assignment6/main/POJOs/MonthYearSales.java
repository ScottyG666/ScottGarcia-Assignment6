package assignment6.main.POJOs;

import java.time.YearMonth;
import java.time.format.DateTimeFormatter;

public class MonthYearSales {
	private static final String PREFIX_FOR_CENTURY = "20";

	private Integer yearThisMonthResidesIn;
	private Integer salesForTheMonth;

	public Integer getSalesForTheMonth() {
		return salesForTheMonth;
	}

	public Integer getYearThisMonthResidesIn() {
		return yearThisMonthResidesIn;
	}
	//
	//Class yearMonth to represent Date
	private YearMonth monthYearComboYMObject;
	
	
	public YearMonth getMonthYearComboYMObject() {
		return monthYearComboYMObject;
	}
	

	

	public MonthYearSales(String cSVValueMonthYearSales) {
		DateTimeFormatter formatterFromString = DateTimeFormatter.ofPattern("LLL-uu");
		this.monthYearComboYMObject = YearMonth.parse(cSVValueMonthYearSales.split(",")[0], formatterFromString);
//		
		
		String salesForInstantiatedMonthString = cSVValueMonthYearSales.split(",")[1];

		String yearThisMonthIsInToTensPlace = cSVValueMonthYearSales.split(",")[0].split("-")[1];

		this.salesForTheMonth = Integer.parseInt(salesForInstantiatedMonthString);

		this.yearThisMonthResidesIn = Integer.parseInt(PREFIX_FOR_CENTURY + yearThisMonthIsInToTensPlace);
	}

	@Override
	public String toString() {
		DateTimeFormatter formatterToString = DateTimeFormatter.ofPattern("uuuu-MM");
		
		return this.getMonthYearComboYMObject().format(formatterToString);
	}
	
	
	
}
