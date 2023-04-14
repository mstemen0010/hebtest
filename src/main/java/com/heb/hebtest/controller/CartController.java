package com.heb.hebtest.controller;

import java.util.List;

import org.springframework.stereotype.Controller;

import com.heb.hebtest.commonobj.virtual.StoreProduct;

@Controller
class CartController {
	List<StoreProduct> cartItems;
}
