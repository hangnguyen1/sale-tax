package calculator;
//Exception class for Tax
public class TaxException extends Exception{
	
	private static final long serialVersionUID = 1L;
    
	//TaxException Constructor
    public TaxException() {
    	super();
	}
		
	//TaxException Constructor accepting a message 
	public TaxException(final String message) {
		System.out.println(message);			
	}
}
