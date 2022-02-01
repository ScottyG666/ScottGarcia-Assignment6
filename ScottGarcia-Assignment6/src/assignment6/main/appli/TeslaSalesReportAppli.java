package assignment6.main.appli;

import assignment6.main.teslasalesreportbymodel.TeslaSalesReportByModel;

public class TeslaSalesReportAppli {
	public static void main(String[] args) {

		TeslaSalesReportByModel modelXSalesReport = new TeslaSalesReportByModel("modelX.csv");
		modelXSalesReport.printSalesReport();
		
		TeslaSalesReportByModel modelSSalesReport = new TeslaSalesReportByModel("modelS.csv");
		modelSSalesReport.printSalesReport();
		
		TeslaSalesReportByModel model3SalesReport = new TeslaSalesReportByModel("model3.csv");
		model3SalesReport.printSalesReport();
		
	}
	
	
	
}
