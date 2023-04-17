package com.heb.hebtest.entity.coupon;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;

@Controller
public class CouponController {
	
	List<Coupon__1> couponList;
	public CouponController() {
		this.loadCouponsFromJsonFile();
			
	}
	
	private void loadCouponsFromJsonFile( ) {
		
		try {
			File jsonFile = new ClassPathResource("data.json").getFile();

			ObjectMapper mapper = new ObjectMapper();
			Coupon coupons = mapper.readValue( jsonFile,  Coupon.class );
			couponList = coupons.getCoupons();
		 
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		}
	
		public double getCouponValueForSku( int sku ) {

		Coupon__1 couponFound = this.couponList.stream()
				.filter(p->p.getAppliedSku().equals(sku))
				.findAny()
				.orElse(null);
				
		return couponFound.getDiscountPrice();
		}
	
}
