package com.heb.hebtest.infrastructure.assest.virtual;

import com.heb.hebtest.entity.coupon.CouponController;
import com.heb.hebtest.entity.grocery.GroceryItem;
import com.heb.hebtest.service.controller.receiptservice.Receipt;

import java.util.List;

public class SoftCart {


	CouponController couponController;

	private List <GroceryItem> cartContents;
	private Receipt cartReceipt;
	
	public SoftCart( ) {
		couponController = new CouponController();
	}

	public void setContents( List<GroceryItem> cartContents) {
		this.cartContents = cartContents;
	}
	
	public List<GroceryItem> getCartContents() {
		return this.cartContents;
	}
	public Receipt getCartReceipt() {
		return cartReceipt;
	}

	public void setCartReceipt(Receipt cartReceipt) {
		this.cartReceipt = cartReceipt;
	}
	
	public double processCoupoms() {
		double totalDiscount =0.0;
		for( GroceryItem item: cartContents) {			
			double discVal = this.couponController.getCouponValueForSku(item.getSku());
			double adjustedPrice = item.getPrice() - discVal;
			totalDiscount += discVal;
			if(  adjustedPrice <= 0.0 )
			{
				adjustedPrice = 0.0;
			}
			item.setPrice(adjustedPrice);
		}
		return totalDiscount;
	}
	
	

}
