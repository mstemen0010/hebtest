package com.heb.hebtest.service.controller.receiptservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.heb.hebtest.infrastructure.assest.virtual.SoftCart;

@RestController
public class ReceiptAPIrComtroller {
	
	
	SoftCart cart;
	// Feature #1 
	@GetMapping("/total")
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
	

}
