package com.heb.hebtest.infrastructure.assest.virtual;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.heb.hebtest.commonobj.virtual.StoreProduct;
import com.heb.hebtest.commonutil.CommonJsonObject;
import com.heb.hebtest.entity.coupon.CouponController;
import com.heb.hebtest.entity.grocery.GroceryItem;
import com.heb.hebtest.service.controller.receiptservice.Receipt;

public class SoftCart {


	@Autowired 
	CouponController couponController;

	private int id; 
	private List <GroceryItem> cartContents;
	private Receipt cartReceipt;
	
	public SoftCart( ) {
				// TODO Auto-generated constructor stub
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
