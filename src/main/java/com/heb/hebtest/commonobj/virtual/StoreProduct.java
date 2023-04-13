package com.heb.hebtest.commonobj.virtual;


import com.heb.hebtest.commonutil.CommonJsonObject;
import com.heb.hebtest.entity.grocery.GroceryEntity;

public class StoreProduct extends CommonJsonObject<StoreProduct> {
	
	GroceryEntity groceryEmtity;
	
	public StoreProduct(String sourceJson, Class<StoreProduct> targetObj) {
		super(sourceJson, targetObj);
	}

}
