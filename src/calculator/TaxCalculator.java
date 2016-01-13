package calculator;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import product.Product;

//class to calculate tax for each product
public class TaxCalculator{
	
	private Product product;
	
	public TaxCalculator(Product product){
		this.product = product;
	}
	
	//Calculates basic sale tax
	public double calculateBasicTax() throws FileNotFoundException{ 
		
		double basicTaxValue = 0.00;
		ArrayList<String> basicTaxWaiverItems = new ArrayList<String>();
		
		//load the tax waiver file (this file can be updated from outside
		Scanner input = new Scanner (new FileInputStream(Constants.TAX_WAIVER_FILE));
		while (input.hasNext()){
			String s = input.next();
			basicTaxWaiverItems.add(s);
		}
		
		ArrayList<Boolean> bo = new ArrayList<Boolean>();
		
		for(int i = 0;i<basicTaxWaiverItems.size(); i++){
			boolean b = product.getName().trim().equalsIgnoreCase(basicTaxWaiverItems.get(i));
			bo.add(b);
			if (bo.contains(true)){
				basicTaxValue = 0.00;
			}
			else {
				basicTaxValue = product.getQuantity() * product.getPrice() * Constants.SALES_TAX_PERCENTAGE/100;
			}
		}
		return basicTaxValue;
	}
	
	//Calculates import duty tax
	public double calculateImportDutyTax(){
		
		double importDutyTaxValue = 0.00;
		
		if (product.getItemType().trim().equalsIgnoreCase(Constants.IMPORTED_TYPE)){
			importDutyTaxValue = product.getPrice() * Constants.IMPORT_DUTY_PERCENTAGE/100;
		}
		else {
			importDutyTaxValue = 0.00;
		}
		
		return importDutyTaxValue;	
	}
	
}
