package com.shadab.invoice.configurations;

import java.util.HashMap;

import static com.shadab.invoice.constants.InvoiceItemConstants.*;
import static com.shadab.invoice.constants.InvoiceIntemCategoryConstants.*;

public class InvoiceConfigurations {

	private static volatile InvoiceConfigurations invoiceConfigurations;

	private static HashMap<String, String> categories = new HashMap<>();
	private static HashMap<String, Double> taxes = new HashMap<>();

	public static HashMap<String, Double> getTaxes() {
		return taxes;
	}

	public static HashMap<String, String> getCategories() {
		return categories;
	}

	private InvoiceConfigurations(HashMap<String, String> categories,HashMap<String, Double> taxes) {
		this.categories = categories;
		this.taxes = taxes;
	}

	public static InvoiceConfigurations getInstance() {

		InvoiceConfigurations invoiceConfigurationsinstance = invoiceConfigurations;
		if (invoiceConfigurationsinstance == null) {
			synchronized (categories) {
				invoiceConfigurationsinstance = invoiceConfigurations;
				if (invoiceConfigurationsinstance == null) {
					categories.put(BOOK, EDUCATION);
					categories.put(PEN, EDUCATION);
					categories.put(CHOCOLATE, FOOD);
					categories.put(WINE, BEVARAGE);
					categories.put(HEADACHE_PILL, HEALTH);
					// taxes
					taxes.put(EDUCATION, 20.00);
					taxes.put(FOOD, 20.00);
					taxes.put(BEVARAGE, 20.00);
					taxes.put(HEALTH, 0.00);
					
					invoiceConfigurations = invoiceConfigurationsinstance = new InvoiceConfigurations(categories,taxes);
				}
			}
		}
		return invoiceConfigurationsinstance;
	}

}
