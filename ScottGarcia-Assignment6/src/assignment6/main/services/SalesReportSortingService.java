package assignment6.main.services;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import assignment6.main.POJOs.MonthYearSales;

public class SalesReportSortingService {

	public Map<Integer, List<MonthYearSales>> convertCSVToListOfSortedYears(String filePath) {
		FileReaderService reader = new FileReaderService();

		Map<Integer, List<MonthYearSales>> holderMap = reader.convertCSVFileToListOfMYSObjects(filePath).stream()
				.collect(Collectors.groupingBy((MYSObject) -> MYSObject.getYearThisMonthResidesIn()));
		return holderMap;

	}

	public MonthYearSales getWorstMonth(String filePath) {
		FileReaderService reader = new FileReaderService();
		return reader.convertCSVFileToListOfMYSObjects(filePath).stream()
																.min(Comparator.comparingInt(month -> month.getSalesForTheMonth()))
																.get();
	}

	public MonthYearSales getBestMonth(String filePath) {
		FileReaderService reader = new FileReaderService();
		return reader.convertCSVFileToListOfMYSObjects(filePath).stream()
																.max(Comparator.comparingInt(month -> month.getSalesForTheMonth()))
																.get();
	}

}
