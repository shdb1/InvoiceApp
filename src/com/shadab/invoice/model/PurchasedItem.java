package com.shadab.invoice.model;

public class PurchasedItem {
  
	private String inputReceivedFromUser;
	private String itemName;
	private String categoryname;
	private double unitPrice;
	private double purchasedQuantity;
	private double taxPercentageToApply;
	private double taxAmountApplied;
	private double totalPriceIncTax;
	private boolean itemValidated;
	private String invalidItemErrorMessage;
	
	public String getInputReceivedFromUser() {
		return inputReceivedFromUser;
	}
	public void setInputReceivedFromUser(String inputReceivedFromUser) {
		this.inputReceivedFromUser = inputReceivedFromUser;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public String getCategoryname() {
		return categoryname;
	}
	public void setCategoryname(String categoryname) {
		this.categoryname = categoryname;
	}
	public double getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}
	public double getPurchasedQuantity() {
		return purchasedQuantity;
	}
	public void setPurchasedQuantity(double purchasedQuantity) {
		this.purchasedQuantity = purchasedQuantity;
	}
	public double getTaxPercentageToApply() {
		return taxPercentageToApply;
	}
	public void setTaxPercentageToApply(double taxPercentageToApply) {
		this.taxPercentageToApply = taxPercentageToApply;
	}
	public double getTaxAmountApplied() {
		return taxAmountApplied;
	}
	public void setTaxAmountApplied(double taxAmountApplied) {
		this.taxAmountApplied = taxAmountApplied;
	}
	public double getTotalPriceIncTax() {
		return totalPriceIncTax;
	}
	public void setTotalPriceIncTax(double totalPriceIncTax) {
		this.totalPriceIncTax = totalPriceIncTax;
	}
	public boolean isItemValidated() {
		return itemValidated;
	}
	public void setItemValidated(boolean itemValidated) {
		this.itemValidated = itemValidated;
	}
	public String getInvalidItemErrorMessage() {
		return invalidItemErrorMessage;
	}
	public void setInvalidItemErrorMessage(String invalidItemErrorMessage) {
		this.invalidItemErrorMessage = invalidItemErrorMessage;
	}


	  
		@Override
		public String toString() {
			return "PurchasedItem [inputReceivedFromUser=" + inputReceivedFromUser + ", itemName=" + itemName
					+ ", categoryname=" + categoryname + ", unitPrice=" + unitPrice + ", purchasedQuantity="
					+ purchasedQuantity + ", taxPercentageToApply=" + taxPercentageToApply + ", taxAmountApplied="
					+ taxAmountApplied + ", totalPriceIncTax=" + totalPriceIncTax + ", itemValidated=" + itemValidated
					+ ", invalidItemErrorMessage=" + invalidItemErrorMessage + "]";
		}

}
