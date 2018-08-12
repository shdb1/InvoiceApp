package com.shadab.invoice;

public class InvoiceAppTester {
	
	public static void main(String[] args) {
		
		String input = "1 bottle of wine: 20.00\n"
		         + "2 box of headache pills: 4.00\n"
				+"1 box of pens: 10.00";
		
		String input2 = "1 book: 30\n"
				+"1 chocolate: 1";
		
		String input3 = "1 pen: 5";
		
		Invoice invoice = new InvoiceImpl();
	invoice.getInvoice(input3);

		
	}

}
