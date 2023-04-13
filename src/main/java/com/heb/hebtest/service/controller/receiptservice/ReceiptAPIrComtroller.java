package com.heb.hebtest.service.controller.receiptservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReceiptAPIrComtroller {
	
	
	@GetMapping("/total")
	
	// Feature #1 
	public String getGrandTotal( String jsonAsString  ) {
		String retJson = null; 
		
		return retJson;
	}
	

}
