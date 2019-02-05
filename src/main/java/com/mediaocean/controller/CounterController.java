package com.mediaocean.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mediaocean.beans.GeneratedBill;
import com.mediaocean.beans.Products;
import com.mediaocean.exceptions.MediaOceanException;
import com.mediaocean.service.BillGenration;

@RestController
@RequestMapping(value = "/RetailStore", produces = APPLICATION_JSON_UTF8_VALUE)
public class CounterController {
	

	@Autowired
	private BillGenration billGenration;

	@RequestMapping(value = "/Checkout", method = RequestMethod.POST)
	public String retrievebillwithobject(@RequestBody List<Products> items,
			@RequestParam(value = "phoneNumber", defaultValue = "Unknown") final String phoneNumber)
			throws JsonProcessingException, MediaOceanException {
		
		
		if (items.isEmpty()) {
			throw new MediaOceanException("Data not found", 100, "Cart is empty");
		} else {

			GeneratedBill bill = billGenration.genrateBill(items, phoneNumber);
			ObjectMapper mapper = new ObjectMapper();
			return mapper.writeValueAsString(bill);

		}

	}

	@RequestMapping(value = "/ShoppingCart", method = RequestMethod.GET)
	public String showAllProducts() throws JsonProcessingException, MediaOceanException {
		List<Products> products = billGenration.showAllPrroducts();

		if (products.isEmpty()) {
			throw new MediaOceanException("Data not found", 100, "Cart is empty");
		}
		ObjectMapper mapper = new ObjectMapper();
		return mapper.writeValueAsString(products);

	}


}



