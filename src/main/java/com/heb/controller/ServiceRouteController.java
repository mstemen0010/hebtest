package com.heb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.heb.hebtest.service.controller.receiptservice.ReceiptComtroller;

/*
	this will be will be a controller to handle all in coming service traffic, this can be replicated to
    scale and provides a central paint for metrics and the like.   
	this element would also allow for protocols like Kafka to be introduced a service layer at a time.
*/


@RestController
public class ServiceRouteController {


	@Autowired
	ReceiptComtroller reciptController;
	
	/* Service mapping/API for Receipt Service */
	
	

}
