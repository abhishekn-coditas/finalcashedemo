package com.coditas;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * The Class Product.
 */
@Entity
public class Product {
	
	/** The id. */
	private Long id;
	
	/** The name. */
	private String name;
	
	/** The brand. */
	private String brand;
	
	/** The madein. */
	private String madein;
	
	/** The price. */
	private Float price;
	
	private Date created;

	/**
	 * Instantiates a new product.
	 */
	public Product() {
	}

	/**
	 * Instantiates a new product.
	 *
	 * @param id the id
	 * @param name the name
	 * @param brand the brand
	 * @param madein the madein
	 * @param price the price
	 */
	protected Product(Long id, String name, String brand, String madein, float price) {
		super();
		this.id = id;
		this.name = name;
		this.brand = brand;
		this.madein = madein;
		this.price = price;
	}

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}

	/**
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name.
	 *
	 * @param name the new name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Gets the brand.
	 *
	 * @return the brand
	 */
	public String getBrand() {
		return brand;
	}

	/**
	 * Sets the brand.
	 *
	 * @param brand the new brand
	 */
	public void setBrand(String brand) {
		this.brand = brand;
	}

	/**
	 * Gets the madein.
	 *
	 * @return the madein
	 */
	public String getMadein() {
		return madein;
	}

	/**
	 * Sets the madein.
	 *
	 * @param madein the new madein
	 */
	public void setMadein(String madein) {
		this.madein = madein;
	}

	/**
	 * Gets the price.
	 *
	 * @return the price
	 */
	public Float getPrice() {
		return price;
	}

	/**
	 * Sets the price.
	 *
	 * @param price the new price
	 */
	public void setPrice(Float price) {
		this.price = price;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created", length = 19, columnDefinition = "datetime DEFAULT CURRENT_TIMESTAMP")
	public Date getCreated() {

		if (this.created == null) {
			this.created = new Date();
		}

		return this.created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}
	
	

}
