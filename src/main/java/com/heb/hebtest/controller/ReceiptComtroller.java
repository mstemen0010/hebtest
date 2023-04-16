package com.heb.hebtest.controller;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.heb.hebtest.entity.grocery.GroceryItem;
import com.heb.hebtest.infrastructure.assest.virtual.SoftCart;
import com.heb.hebtest.service.controller.receiptservice.Receipt;
import com.heb.hebtest.service.controller.receiptservice.Receipt.ReceiptFieldType;


@RestController
public class ReceiptComtroller {
	
	
	SoftCart cart;
	Receipt receipt;
	// Feature #1 
	@PostMapping(
            value = "/total",
            consumes = "application/json")
	// public String sumTotal( @RequestBody String items ) {
	public String sumTotal( @RequestBody List<GroceryItem> items ) {
		receipt = new Receipt();
		EnumSet.of(ReceiptFieldType.GrandTotal);
		System.out.println("Got: " + items );
		//List<GroceryItem> itemsList = new ArrayList<GroceryItem>();
		Double sum = items.stream()
				  .map(x -> x.getPrice())
				  .collect(Collectors.summingDouble(Double::doubleValue));
		
		receipt.setTotal(sum);
		return "sum is: " + sum;
	}
	
	public String getGrandTotal( String jsonAsString  ) {
		String retJson = null; 
		
		// return retJson;
		return "Grand Total is: ";
	}
	
	
	// Feature #2
	@GetMapping("/sub")
	public String getSubtotal( String jsonAsString) {
		StringBuilder sb = new StringBuilder();
		
		sb.append("Subtotal:").append("\n");
		sb.append("Tax total:").append("\n");;
		sb.append( getGrandTotal( jsonAsString )).append("\n");
		
		return sb.toString();
	}
	
	@GetMapping("/error")
	public String showError() {
		return "Invalid Service request";
	}

}
