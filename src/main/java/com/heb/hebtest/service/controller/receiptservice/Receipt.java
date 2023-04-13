package com.heb.hebtest.service.controller.receiptservice;

import java.util.EnumSet;

public class Receipt {
	
	public enum ReceiptFieldType {
		Coupons,
		TaxableItems,
		AllItemsTaxable,
		Subtotal,
		GrandTotal;
		
	}
	
	private EnumSet<ReceiptFieldType> receiptType;
	
	
	float total;
	float allTaxTotal;
	float taxableTotal;
	float couponTotal;
	public float getTotal() {
		return total;
	}
	public void setTotal(float total) {
		this.total = total;
	}
	public float getAllTaxTotal() {
		return allTaxTotal;
	}
	public void setAllTaxTotal(float allTaxTotal) {
		this.allTaxTotal = allTaxTotal;
	}
	public float getTaxableTotal() {
		return taxableTotal;
	}
	public void setTaxableTotal(float taxableTotal) {
		this.taxableTotal = taxableTotal;
	}
	public float getCouponTotal() {
		return couponTotal;
	}
	public void setCouponTotal(float couponTotal) {
		this.couponTotal = couponTotal;
	}
	
}