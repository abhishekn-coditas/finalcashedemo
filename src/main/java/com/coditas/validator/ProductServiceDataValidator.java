package com.coditas.validator;



import java.util.ArrayList;
import java.util.List;

import org.springframework.util.StringUtils;

import com.coditas.Product;
import com.coditas.ProductDto;

public class ProductServiceDataValidator  {
	
	private ProductServiceDataValidator() {}

	public static List<String> validateProductData(ProductDto product) {
		List<String> errors = new ArrayList<>();
		if(StringUtils.isEmpty(product.getName())) {
			String error = "Product Name is required.";
			errors.add(error);
		}
		if(StringUtils.isEmpty(product.getBrand())) {
			String error = "Brand is required.";
			errors.add(error);
		}
		if(StringUtils.isEmpty(product.getMadein())) {
			String error = "Made In is required.";
			errors.add(error);
		}
		if(null==product.getPrice()) {
			String error = "Price is required.";
			errors.add(error);
		}		
		return errors;
	}
	
}
