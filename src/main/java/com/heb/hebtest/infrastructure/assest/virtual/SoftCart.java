package com.heb.hebtest.infrastructure.assest.virtual;

import java.util.List;
import java.util.Map;

import com.heb.hebtest.commonobj.virtual.StoreProduct;
import com.heb.hebtest.commonutil.CommonJsonObject;
import com.heb.hebtest.service.controller.receiptservice.Receipt;

public class SoftCart extends CommonJsonObject<SoftCart> {

	private int id; 
	private List <StoreProduct> contentsOfCart;
	private Receipt cartReceipt;
	private String rawJson;
	
	public SoftCart(String sourceJson, Class<SoftCart> targetObj) {
		super(sourceJson, targetObj);
		// TODO Auto-generated constructor stub
	}

}
