package databuilder;

import java.util.ArrayList;
import java.util.List;

import com.coditas.Product;

public class ProductBuilder {
	
	public static List<Product> getProductList(){
		List<Product> list = new ArrayList<>();
		list.add(createProduct(1L));
		list.add(createProduct(2L));
		return list;
	}
	
	public static Product createProduct(Long id) {
		Product p = new Product();
		p.setId(id);
		p.setBrand("Brand"+id);
		p.setName("Product"+id);
		p.setMadein("India");
		p.setPrice(100);
		return p;
	}

}
