package com.heb.hebtest.entity.grocery;

import java.util.ArrayList;
import java.util.List;

public class GroceryItemList extends ArrayList<GroceryItem> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	ArrayList<GroceryItem> items = null;

	public ArrayList<GroceryItem> getItems() {
		return items;
	}

	public void setItems(List<GroceryItem> items) {

		items = new ArrayList<GroceryItem>(items);
	}
	

}
