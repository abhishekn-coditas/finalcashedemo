
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.coditas.Product;
import com.coditas.ProductRepository;
import com.coditas.ProductService;

import databuilder.ProductBuilder;

@RunWith(MockitoJUnitRunner.Silent.class)
public class ProductServiceTest {

	@InjectMocks
	ProductService service;
	
	@Mock
	ProductRepository repository;
	
	@Test
	public void testFindAllProducts() {
		when(repository.findAll()).thenReturn(ProductBuilder.getProductList());
		Assert.assertEquals("Product List size should be 2.",2,service.listAll().size());
	}
	
	@Test
	public void testGetProductById() {
		when(repository.findById(1L)).thenReturn(Optional.of(ProductBuilder.createProduct(1L)));
		assertNotNull("Product Object should not be null", service.get(1L));
	}
	
	@Test
	public void saveUpdateProduct() {
		Product product = ProductBuilder.createProduct(1L);
		when(repository.save(any())).thenReturn(product);
		service.save(product);
	}
	
	@Test
	public void deleteProductById() {
		service.delete(Mockito.anyLong());
	}
	
	

}
