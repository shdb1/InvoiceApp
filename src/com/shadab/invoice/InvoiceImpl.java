/**
 * 
 */
package com.shadab.invoice;

 import java.util.List;

import com.shadab.invoice.model.PurchasedItem;
import com.shadab.invoice.util.InvoiceUtils;

/**
 * @author mshadab
 *
 */
public class InvoiceImpl implements Invoice{
	
	 
	@Override
	public void getInvoice(String purchasedItems) {
		// TODO Auto-generated method stub
		
		// initialize the categories for the application
 		List<PurchasedItem> calculatedItems = InvoiceUtils.parsePurchaseListAndPerformCalculations(purchasedItems);
  		printInvoice(calculatedItems);
		
	}

	@Override
	public void printInvoice(List<PurchasedItem> calculatedItems) {
		// TODO Auto-generated method stub
		StringBuffer totalAmountMessage = new StringBuffer("Total:");
		StringBuffer totalSaleTaxMessage = new StringBuffer("Sales Taxes:");
		double totalAmount = 0.00;
		double totalSaleTaxs = 0.00;
		for( PurchasedItem calculatedItem : calculatedItems) {
			if(calculatedItem.isItemValidated()) {
				// item successfully processed
				System.out.println(calculatedItem.getInputReceivedFromUser().split(":")[0]+" :"+calculatedItem.getTotalPriceIncTax());
				totalAmount = totalAmount + calculatedItem.getTotalPriceIncTax();
				totalSaleTaxs = totalSaleTaxs + calculatedItem.getTaxAmountApplied();
			}
			else {
				// could not process the item
				System.out.println(calculatedItem.getInputReceivedFromUser()+"Error Ocuured:"+calculatedItem.getInvalidItemErrorMessage());
			}
			
			
		}
		System.out.println(totalSaleTaxMessage.append(totalSaleTaxs));
		System.out.println(totalAmountMessage.append(totalAmount));
		
		
	}

}
