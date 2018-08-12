package com.shadab.invoice.util;

import java.util.ArrayList;
import java.util.List;

import com.shadab.invoice.configurations.InvoiceConfigurations;
import com.shadab.invoice.exceptions.CategoryNotFoundException;
import com.shadab.invoice.exceptions.InvoiceException;
 import com.shadab.invoice.exceptions.TaxNotFoundException;
import com.shadab.invoice.model.PurchasedItem;

public class InvoiceUtils {

	public static List<PurchasedItem> parsePurchaseListAndPerformCalculations(String purchaseInfo) {

		List<PurchasedItem> purchasedItems = new ArrayList<>();
		
		// split multi line inputs
		String listOfPurchasedItem[] = purchaseInfo.split("\\r?\\n");

		for (String eachPurchasedItem : listOfPurchasedItem) {

			PurchasedItem purchasedItem = new PurchasedItem();
 			try {
				
				String[] eachPurchaseInfo = eachPurchasedItem.split(" ");
				purchasedItem.setInputReceivedFromUser(eachPurchasedItem);
				purchasedItem.setPurchasedQuantity(Double.parseDouble(eachPurchaseInfo[0]));
				if(eachPurchaseInfo.length==3) {
				
				
				purchasedItem.setUnitPrice(Double.parseDouble(eachPurchaseInfo[2]));
				purchasedItem.setItemName(eachPurchaseInfo[1].substring(0, eachPurchaseInfo[1].length() - 1));
				}
				else {
					String[] eachPurchaseInfoWithOtherSplitter = eachPurchasedItem.split("of");
					purchasedItem.setUnitPrice(Double.parseDouble(eachPurchaseInfoWithOtherSplitter[1].split(":")[1]));
					purchasedItem.setItemName(eachPurchaseInfoWithOtherSplitter[1].split(":")[0]);
					
				}
				
				purchasedItem.setCategoryname(getCategory(purchasedItem.getItemName()));
 				
				// calculate prices with taxes
				setSalePricesWithTaxes(purchasedItem);
				
				// mark item as successfully processed
				purchasedItem.setItemValidated(true);
				
				// add item after all processing to the final list
				purchasedItems.add(purchasedItem);

			} catch (InvoiceException invoiceException) {
				// TODO: handle exception
				purchasedItem.setItemValidated(false);
				purchasedItem.setInvalidItemErrorMessage(invoiceException.getMessage());
				invoiceException.printStackTrace();
			}

		}

		return purchasedItems;
	}

	public static String getCategory(String itemName) throws CategoryNotFoundException {
		String category = "notfound";
		try {
 			category = InvoiceConfigurations.getInstance().getCategories().get(itemName.trim().replace(" ", "_"));
 		} catch (Exception exception) {
			// TODO Auto-generated catch block
			throw new CategoryNotFoundException("could not find category for the item :"+itemName);
		}
		
		return category;

	}
	
	public static PurchasedItem setSalePricesWithTaxes(PurchasedItem purchasedItem) throws TaxNotFoundException{
		
		double tax=0.0;
		try {
			double taxPercentage = InvoiceConfigurations.getTaxes().get(purchasedItem.getCategoryname());
			double totalAmountToBePaidWithoutTax = purchasedItem.getPurchasedQuantity() * purchasedItem.getUnitPrice();
			double taxAmountTobePiad = (taxPercentage *  totalAmountToBePaidWithoutTax) / 100;
			double totalAmountTobePaidWithTaxes = totalAmountToBePaidWithoutTax + taxAmountTobePiad;
			
 			purchasedItem.setTaxPercentageToApply(taxPercentage);
			purchasedItem.setTaxAmountApplied(taxAmountTobePiad);
			purchasedItem.setTotalPriceIncTax(totalAmountTobePaidWithTaxes);
			
 			
			
		} catch (Exception exception) {
			// TODO Auto-generated catch block
			throw new TaxNotFoundException("could not find tax percentage for item: "+purchasedItem.getInputReceivedFromUser());
		}
		
		
		return purchasedItem;
	}

}
