package com.heb.hebtest.entity.grocery;
 
public class GroceryEntity {
	
    private long id; 
	private String itemName;
	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public boolean isTaxable() {
		return isTaxable;
	}

	public void setTaxable(boolean isTaxable) {
		this.isTaxable = isTaxable;
	}

	public boolean isOwnBrand() {
		return isOwnBrand;
	}

	public void setOwnBrand(boolean ownBrand) {
		this.isOwnBrand = ownBrand;
	}

	private int sku;
	private boolean isTaxable;
	private boolean isOwnBrand;
	private double price;
 
    public GroceryEntity() {
    	
    }
    
    public GroceryEntity (int sku, String itemName, boolean isTaxable, boolean isOwnBrand, double price ) {
    	this.setSku(sku);
    	this.setItemName(itemName);
    	this.setIsTaxable(isTaxable);
    	this.setIsOwnBrand(isOwnBrand);
    	this.setPrice(price);
    }
    
	private void setIsOwnBrand(boolean isOwnBrand) {
		this.isOwnBrand = isOwnBrand;	
	}

	private void setIsTaxable(boolean isTaxable2) {
		// TODO Auto-generated method stub
		
	}

	public long getId() {
		return id;
	}
	
	void setId(long id) {
		this.id = id;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getSku() {
		return sku;
	}

	public void setSku(int sku) {
		this.sku = sku;
	}
 
}