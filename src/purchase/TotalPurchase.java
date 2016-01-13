package purchase;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import calculator.SaleCalculator;
import calculator.TaxException;
import product.Product;

//class contains main method
public class TotalPurchase {
	
	//main method
	public static void main(String[] args) throws IOException  {
		
		String again = "y";
	    Scanner in = new Scanner(System.in);
	    
	    while (again.equalsIgnoreCase("y"))
		{
	    	try
	    	{
	    		System.out.println("Please enter location of the input file (for example, D:\\input1.txt)");
			    fileEntry();
			} 
	    	catch (TaxException e) {
				System.out.println( e.getMessage());
			}
		    System.out.println();
		    System.out.println("Do you want to continue? (Enter y/Y for Yes or n/N for No)");
		    again = in.next();
		}
	}

	//input file of purchased products
	private static void fileEntry() throws TaxException, IOException {
		
		Scanner input = new Scanner (System.in);
		String fileLocation = input.next();
		Product products = null ;
		
		try {
			products = SaleCalculator.processFileInformation(new File(fileLocation),products);
		} 
		catch (FileNotFoundException e) {
			System.out.println("File not found");
		}
	}
	
}

