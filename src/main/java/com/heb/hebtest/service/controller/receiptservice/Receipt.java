package com.heb.hebtest.service.controller.receiptservice;

import java.util.EnumSet;
import java.util.Map;
import java.util.HashMap;

public class Receipt {
	
	public enum ReceiptFieldType {
		Subtotal,
		SubtotalBeforeDiscounts,
		DiscountTotal,
		SubtotalWithDiscounts,
		TaxableSubTotal,
		TaxableTotal,
		CouponTotal,
		TaxableSubtotalAfterDiscount,
		TaxableItems,
		AllItemsTaxable,
		GrandTotal;
		
	}
	
	private EnumSet<ReceiptFieldType> receiptType;
	
	
	double taxRate;
	
	
	Map<ReceiptFieldType, Double > receiptFields = new HashMap<ReceiptFieldType, Double>();
	
	public double getTaxRate() {
		return taxRate;
	}

	public void setTaxRate(double taxRate) {
		this.taxRate = taxRate;
	}
	
	public void addTaxOnField( ReceiptFieldType receiptFieldType ) {
		if  (receiptFields.containsKey(receiptFieldType)) {
			double fieldValue = receiptFields.get(receiptFieldType);
			double calcedTax = fieldValue * this.getTaxRate();
			double newGrandTotal = fieldValue + calcedTax;
			receiptFields.put(ReceiptFieldType.TaxableSubTotal, fieldValue);
			receiptFields.put(ReceiptFieldType.TaxableTotal, calcedTax );
			receiptFields.put( ReceiptFieldType.GrandTotal, newGrandTotal);
			receiptType.add( ReceiptFieldType.TaxableTotal);
		}
	}
	
	public void applySalesTaxToTaxaAbleSum( double subTotal, double sumOfTaxable ) {
		 receiptType.add(ReceiptFieldType.TaxableSubTotal);
		 receiptFields.put( ReceiptFieldType.TaxableSubTotal, sumOfTaxable);
		 double tax = sumOfTaxable * this.getTaxRate();
		 receiptType.add( ReceiptFieldType.TaxableTotal);
		 receiptFields.put( ReceiptFieldType.TaxableTotal, tax);
		 double newGrandTotal = subTotal + tax;
		 receiptFields.put(ReceiptFieldType.GrandTotal, newGrandTotal);
	}

	public Receipt() {
		this.receiptType = EnumSet.noneOf(ReceiptFieldType.class);
		this.setTaxRate(.0825);
	}

	public Receipt( EnumSet<ReceiptFieldType> enumSet ) {
		this.receiptType = enumSet;
		this.setTaxRate(.0825);
	}
	
	public void addFieldAndValue( ReceiptFieldType field, double value) {
		this.receiptType.add(field);
		this.receiptFields.put( field, value);
	}
	
	public void setReceiptType( EnumSet<ReceiptFieldType> recieptType ) {
		this.receiptType = EnumSet.copyOf( receiptType );		
	}
	
	public void addReceiptFieldType( ReceiptFieldType receiptFieldType ) {
		receiptType.add(receiptFieldType);
	}
	
	public void removeReceiptType( ReceiptFieldType receiptFieldType ) {
		receiptType.remove( receiptFieldType );
	}
	
	public void setSubTotal( double newValue ) {
		this.receiptType.add( ReceiptFieldType.Subtotal);
		this.receiptFields.put( ReceiptFieldType.Subtotal, newValue );
	}
		
	public void setGrandTotal( double newValue ) {
		this.receiptType.add( ReceiptFieldType.GrandTotal );
		this.receiptFields.put( ReceiptFieldType.GrandTotal, newValue );
	}

	public String toJson() {
		StringBuilder jsonStrBuilder = new StringBuilder("{ \n \"Recipt\": { \n");

		for( ReceiptFieldType receiptFieldType: receiptType ) {
			if( receiptFieldType.equals(ReceiptFieldType.Subtotal) ) {
				jsonStrBuilder.append( "\t\"Sub total:\"");
				jsonStrBuilder.append(String.format( "%.2f", this.receiptFields.get(ReceiptFieldType.Subtotal)));
				jsonStrBuilder.append(",\n");
			}
		
			if( receiptFieldType.equals(ReceiptFieldType.TaxableSubTotal) ) {
				jsonStrBuilder.append( "\t\"Taxable subtotal:\"");
				jsonStrBuilder.append(String.format( "%.2f",  this.receiptFields.get(ReceiptFieldType.TaxableSubTotal)));
				jsonStrBuilder.append("\n");
			}
			
	   		if( receiptFieldType.equals(ReceiptFieldType.DiscountTotal) ) {
				jsonStrBuilder.append( "\t\"Discount total:\"");
				jsonStrBuilder.append( String.format( "%.2f", this.receiptFields.get(ReceiptFieldType.DiscountTotal)));
				jsonStrBuilder.append("\n");
			}
	   		
	   		if( receiptFieldType.equals(ReceiptFieldType.SubtotalBeforeDiscounts) ) {
				jsonStrBuilder.append( "\t\"Subtotal before discount:\"");
				jsonStrBuilder.append( String.format( "%.2f", this.receiptFields.get(ReceiptFieldType.SubtotalBeforeDiscounts)));
				jsonStrBuilder.append("\n");
			}
	   		
	   		if( receiptFieldType.equals(ReceiptFieldType.DiscountTotal) ) {
				jsonStrBuilder.append( "\t\"Discount total:\"");
				jsonStrBuilder.append( String.format( "%.2f", this.receiptFields.get(ReceiptFieldType.DiscountTotal)));
				jsonStrBuilder.append("\n");
			}
	   		   
			if( receiptFieldType.equals(ReceiptFieldType.SubtotalWithDiscounts) ) {
				jsonStrBuilder.append( "\t\"Subtotal after discounts:\"");
				jsonStrBuilder.append( String.format( "%.2f", this.receiptFields.get(ReceiptFieldType.SubtotalWithDiscounts)));
				jsonStrBuilder.append("\n");
			}
			
			if( receiptFieldType.equals(ReceiptFieldType.TaxableTotal) ) {
				jsonStrBuilder.append( "\t\"Tax total:\"");
				jsonStrBuilder.append(String.format( "%.2f", this.receiptFields.get(ReceiptFieldType.TaxableTotal)) );
				jsonStrBuilder.append(",\n");
			}	
			
	   		if( receiptFieldType.equals(ReceiptFieldType.GrandTotal) ) {
				jsonStrBuilder.append( "\t\"Grand total:\"");
				jsonStrBuilder.append( String.format( "%.2f", this.receiptFields.get(ReceiptFieldType.GrandTotal)));
				jsonStrBuilder.append("\n");
			}
	   		
		}
		jsonStrBuilder.append("\n\t\t}\n}\n\n");
		return jsonStrBuilder.toString();
	}
	
	public void clear() {
		receiptType.clear();		
	}

	public void reset( boolean resetTaxRate ) {
		clear();
		this.receiptFields.clear();
		if( resetTaxRate ) {
			this.taxRate = 0.0;
		}
	}
	
}