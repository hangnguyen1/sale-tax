package product;
import java.io.FileNotFoundException;

import calculator.TaxCalculator;

//Product class defines purchased product

public class Product { 

	private int quantity;
	private String itemType;
	private String name;
	private double price;
	private double taxAmount;
	
	private TaxCalculator taxCalculator;

	//constructor
	public Product(int quantity, String itemType, String name, double price){
		this.quantity = quantity;
		this.itemType = itemType;
		this.name = name;
		this.price = price;
		taxCalculator = new TaxCalculator(this);	
	}

	//get quantity
	public int getQuantity() {
		return quantity;
	}
	
	//set quantity 
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	//get item type: local or imported
	public String getItemType() {
		return itemType;
	}
    
	//set item type
	public void setItemType(String itemType) {
		this.itemType = itemType;
	}

	//get name 
	public String getName() {
		return this.name;
	}

	//set name
	public void setName(String name) {
		this.name = name;
	}

	//get price 
	public double getPrice() {
		return price;
	}

	//set price
	public void setPrice(double price) {
		this.price = price;
	}

    //get tax amount
	public double getTaxAmount() {
		return taxAmount;
	}
	
	//set tax amount
	public void setTaxAmount(double taxAmount) {
		this.taxAmount =  taxAmount;
	}

	//compute tax
	public double computeTax() throws FileNotFoundException  {
		return (taxCalculator.calculateBasicTax() + taxCalculator.calculateImportDutyTax());
	}
	
	//print imported product
	public String printImportedProduct (){
		return quantity + itemType + name;
	}
	
	//print local product
    public String printLocalProduct (){
		return quantity + name;
	}
	
	//compute total price
	public double totalPrice (){
		return quantity*price + taxAmount;
	}

}

