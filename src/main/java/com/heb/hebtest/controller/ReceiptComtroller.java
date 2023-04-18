package com.heb.hebtest.controller;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.heb.hebtest.entity.coupon.CouponController;
import com.heb.hebtest.entity.grocery.GroceryItem;
import com.heb.hebtest.infrastructure.assest.virtual.SoftCart;
import com.heb.hebtest.service.controller.receiptservice.Receipt;
import com.heb.hebtest.service.controller.receiptservice.Receipt.ReceiptFieldType;

@RestController
public class ReceiptComtroller {

	SoftCart cart;
	Receipt receipt;
	Double sum = 0.0;
	double taxableSum = 0.0;
	
	public ReceiptComtroller() {
		this.receipt = new Receipt();
		cart = new SoftCart();
		cart.setCartReceipt(receipt);
	}
	
	// Feature #1
	@PostMapping(value = { "/total", "/1" }, consumes = "application/json")
	public String sumTotal(@RequestBody List<GroceryItem> items) {
		cart.setContents(items);
		receipt.reset(false);
		receipt.addReceiptFieldType(ReceiptFieldType.GrandTotal);
		sum = items.stream().map(x -> x.getPrice()).collect(Collectors.summingDouble(Double::doubleValue));

		receipt.setGrandTotal(sum);
		return receipt.toJson();
	}

	// Feature #2
	@PostMapping(value = { "/calcTaxAll", "/2" }, consumes = "application/json")
	public String subTotal(@RequestBody List<GroceryItem> items) {
		cart.setContents(items);
		StringBuilder sb = new StringBuilder();
		receipt.reset(false);
		sumTotal(items);
		receipt.setSubTotal(sum);
		receipt.addReceiptFieldType(ReceiptFieldType.AllItemsTaxable);
		receipt.addReceiptFieldType(ReceiptFieldType.GrandTotal);
		receipt.addTaxOnField(ReceiptFieldType.GrandTotal);

		return receipt.toJson();
	}

	// Feature #3
	@PostMapping(value = { "/calcTaxable", "/3" }, consumes = "application/json")
	public String sumAndTaxTotal(@RequestBody List<GroceryItem> items) {
		cart.setContents(items);
		receipt.reset(false);
		receipt.addReceiptFieldType(ReceiptFieldType.GrandTotal);
		sumTotal(items);
		receipt.setSubTotal(sum);
		taxableSum = items.stream().filter(w -> w.getIsTaxable()).map(x -> x.getPrice())
				.collect(Collectors.summingDouble(Double::doubleValue));
		
		receipt.applySalesTaxToTaxaAbleSum(sum, taxableSum);
		return receipt.toJson();
	}
	
	// Feature #4
		@PostMapping(value = { "/calcAllAppyCoupons", "/4" }, consumes = "application/json")
		public String sumAllApplyCoupons(@RequestBody List<GroceryItem> items) {			
			double subTotalBeforeDiscount= items.stream().map(x -> x.getPrice()).collect(Collectors.summingDouble(Double::doubleValue));
			receipt.addFieldAndValue( ReceiptFieldType.SubtotalBeforeDiscounts, subTotalBeforeDiscount);

			cart.setContents(items);
			double discountTotal = cart.processCoupoms();
			List<GroceryItem> adjustedCartItems = cart.getCartContents();
			receipt.addFieldAndValue(ReceiptFieldType.DiscountTotal, discountTotal);
			
			double subTotalAfterDiscount = subTotalBeforeDiscount - discountTotal;
			receipt.addFieldAndValue( ReceiptFieldType.SubtotalAfterDiscounts, subTotalAfterDiscount);
			
			double taxableSubTotalAfterDiscount = adjustedCartItems.stream().filter(w -> w.getIsTaxable()).map(x -> x.getPrice())
					.collect(Collectors.summingDouble(Double::doubleValue));
		
			taxableSubTotalAfterDiscount -= discountTotal;
			double salesTax = receipt.applySalesTaxToTaxaAbleSum(subTotalBeforeDiscount, taxableSubTotalAfterDiscount);
			receipt.addFieldAndValue(ReceiptFieldType.DiscountTotal, discountTotal);
			receipt.removeReceiptType(ReceiptFieldType.TaxableSubTotal);
			
		
			receipt.addFieldAndValue( ReceiptFieldType.TaxableSubtotalAfterDiscount, taxableSubTotalAfterDiscount );

			
			receipt.addFieldAndValue(ReceiptFieldType.TotalTax, salesTax);
	
			return receipt.toJson();
		}

}
