package calculator;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;

import product.Product;

//class calculates total tax and total price of all purchased products
public class SaleCalculator {

	public static Product processFileInformation (File file, Product item) throws TaxException, IOException {
		
		try{
			BufferedReader bfr = new BufferedReader(new FileReader(file)); //read input file of purchased products
			String line = null;
			String s1, s2, s3, s4;
			double totalTax = 0; 
			double totalPrice = 0;
		
			while((line = bfr.readLine()) != null){
				String [] sa = new String [4];
				sa = line.split(",");
				s1=sa[0]; //quantity 
				s2=sa[1]; //item type
				s3=sa[2]; //name
				s4=sa[3]; //price
				item = new Product(Integer.valueOf(s1), s2, s3, Double.valueOf(s4));
				item.setTaxAmount(item.computeTax());
				
				//print each product with the its total price
				if (s2.trim().equalsIgnoreCase(Constants.IMPORTED_TYPE)) {
					System.out.println(item.printImportedProduct() + ": "+ round(item.totalPrice())); 
				}
				else if (s2.trim().equalsIgnoreCase(Constants.LOCAL_TYPE)) {
					System.out.println(item.printLocalProduct() + ": "+ round(item.totalPrice())); 
				}
							
				totalTax += item.getTaxAmount(); //sum total tax
				totalPrice += item.totalPrice(); //sum total price
			} 
			
			System.out.println("Sales Taxes: " + round(totalTax));
			System.out.println("Total: " + round(totalPrice));
			
			bfr.close(); //close input file of purchased products
		}
		catch (StringIndexOutOfBoundsException e) {
			throw new TaxException("String index exceeds the limit");
		}
		return item;
	}
	
	//round big decimal number to the nearest 0.05
	public static double round(double value) {

	    BigDecimal bd = new BigDecimal(value);
	    bd = bd.setScale(2, RoundingMode.HALF_UP);
	    return bd.doubleValue();
	    
	}
	
}
