package com.coditas.util;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.CollectionUtils;

import com.coditas.Product;

// TODO: Auto-generated Javadoc
/**
 * The Class DataCacheUtil.
 */
public class DataCacheUtil {
	
	
	/** The Constant LOG. */
	protected static final Logger LOG = LoggerFactory.getLogger(DataCacheUtil.class);
	
	/** The cache. */
	private static ConcurrentHashMap<Long, Product> cache = new ConcurrentHashMap<>(3);
	
	/**
	 * Gets the cache object.
	 *
	 * @return the cache object
	 */
	public static ConcurrentMap<Long, Product> getCacheObject(){
		return cache;
	}
	
	/**
	 * Gets the all.
	 *
	 * @return the all
	 */
	public static List<Product> getAll() {
		List<Product> list =  cache.values().stream().collect(Collectors.toList());
		sortList(list);
		return list;
	}
	
	/**
	 * Put all.
	 *
	 * @param list the list
	 */
	public static void putAll(List<Product> list){
		clear();
		list.forEach(product->{
			put(product.getId(),product);
		});
	}
	
	/**
	 * Put.
	 *
	 * @param cacheKey the cache key
	 * @param value the value
	 */
	public static void put(Long cacheKey, Product value) {
        cache.put(cacheKey, value);
    }

    /**
     * Gets the.
     *
     * @param cacheKey the cache key
     * @return the product
     */
    public static Product get(Long cacheKey) {
        return cache.get(cacheKey);
    }

    /**
     * Removes the.
     *
     * @param cacheKey the cache key
     * @return the product
     */
    public static Product remove(Long cacheKey) {
        return cache.remove(cacheKey);
    }
    
    /**
     * Replace.
     *
     * @param cacheKey the cache key
     * @param value the value
     * @return the product
     */
    public static Product replace(Long cacheKey, Product value) {
        return cache.replace(cacheKey, value);
    }
    
    /**
     * Clear.
     *
     * @param cacheKey the cache key
     */
    public static void clear(Long cacheKey) {
        cache.put(cacheKey, null);
    }

    /**
     * Clear.
     */
    public static void clear() {
        cache.clear();
    }
    
    /**
     * Gets the size.
     *
     * @return the size
     */
    public static int getSize() {
    	return cache.size();
    }
    
    /**
     * Checks if is element exists.
     *
     * @param cacheKey the cache key
     * @return true, if is element exists
     */
    public static boolean isElementExists(Long cacheKey) {
    	return cache.containsKey(cacheKey);
    }
    
    /**
     * Removes the last.
     */
    public static void removeLast() {
    	List<Product> list = getAll();
	    	Product product = list.remove(list.size()-1);
	    	LOG.info("[DataCacheUtil] Removed product : {}",product.getName());
	    	cache.remove(product.getId());
    }
    
    /**
     * Sort list.
     *
     * @param list the list
     */
    public static void sortList(List<Product> list){
    	if(!CollectionUtils.isEmpty(list)) {
    		Collections.sort(list, (p1,p2)->p2.getCreated().compareTo(p1.getCreated()));
    	}
    }
}
