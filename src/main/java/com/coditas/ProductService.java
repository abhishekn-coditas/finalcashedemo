package com.coditas;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.coditas.util.DataCacheUtil;

/**
 * The Class ProductService.
 */
@Service
@Transactional
public class ProductService {
	
	/** The Constant LOG. */
	protected static final Logger LOG = LoggerFactory.getLogger(ProductService.class);

	/** The repo. */
	@Autowired
	private ProductRepository repo;
	
	/**
	 * List all.
	 *
	 * @return the list
	 */
	public List<Product> listAll() {
		LOG.info("[ProductService] getting product list from db");
		List<Product>list = repo.findAll();
		LOG.info("[ProductService] list size : {}",list.size());
		return list;
	}
	
	/**
	 * Recent product list.
	 *
	 * @return the list
	 */
	public List<Product> recentProductList() {
		List<Product>list = null;
		if(DataCacheUtil.getSize() > 0) {
			LOG.info("[ProductService] getting product list from cache");
			list = DataCacheUtil.getAll();
		}
		return list;
	}	
	
	/**
	 * Save.
	 *
	 * @param product the product
	 */
	public void save(Product product) {
		repo.save(product);
		if(DataCacheUtil.getSize() > 2) {
			DataCacheUtil.removeLast();
		}
		DataCacheUtil.put(product.getId(), product);
		LOG.info("[ProductService] saved product {} successfully.",product.getId());
	}
	
	/**
	 * Gets the.
	 *
	 * @param id the id
	 * @return the product
	 */
	public Product get(long id) {
		if(DataCacheUtil.isElementExists(id)) {
			LOG.info("[ProductService] getting product record from cache");
			return DataCacheUtil.get(id);
		}
		Optional<Product> product = repo.findById(id);
		if(product.isPresent()) {
			LOG.info("[ProductService] getting product record from db");
			return product.get();
		}
		return null;
	}
	
	/**
	 * Delete.
	 *
	 * @param id the id
	 */
	public void delete(long id) {
		LOG.info("[ProductService] deleting product with id : {}",id);
		repo.deleteById(id);
		DataCacheUtil.remove(id);
	}
	
	/**
	 * Flush.
	 */
	public void flush() {
		LOG.info("[ProductService] cache is empty.");
		DataCacheUtil.clear();
	}
	
}
