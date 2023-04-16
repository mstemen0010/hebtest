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
	
	
	double total;
	double allTaxTotal;
	double taxableTotal;
	double couponTotal;
	
	public Receipt() {
		this.receiptType = EnumSet.noneOf(ReceiptFieldType.class);
	}
	
	public Receipt( EnumSet<ReceiptFieldType> enumSet ) {
		this.receiptType = enumSet;
	}
	public double getTotal() {
		return total;
	}
	
	public void setTotal(double total) {
		this.total = total;
	}
	public double getAllTaxTotal() {
		return allTaxTotal;
	}
	public void setAllTaxTotal(double allTaxTotal) {
		this.allTaxTotal = allTaxTotal;
	}
	public double getTaxableTotal() {
		return taxableTotal;
	}
	public void setTaxableTotal(double taxableTotal) {
		this.taxableTotal = taxableTotal;
	}
	public double getCouponTotal() {
		return couponTotal;
	}
	public void setCouponTotal(double couponTotal) {
		this.couponTotal = couponTotal;
	}
	
	public void setReceiptType( EnumSet<ReceiptFieldType> recieptType ) {
		
	}
	
	
	public void addReceiptType( ReceiptFieldType receiptFieldType ) {
		
	}
	
	public String toJson() {
		String json = null;

		return json;
	}
	
	public void reset() {
		receiptType.clear();		
	}
	
	
}