package com.shadab.invoice;

import java.util.List;

import com.shadab.invoice.model.PurchasedItem;

public interface Invoice {
	

	public void getInvoice(String purchasedItems);
	public void printInvoice(List<PurchasedItem> calculatedItems);
	

}
