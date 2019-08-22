package com.coditas;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

// TODO: Auto-generated Javadoc
/**
 * The Class AppController.
 */
@Controller
public class AppController {

	/** The service. */
	@Autowired
	private ProductService service; 
	
	/**
	 * View home page.
	 *
	 * @param model the model
	 * @return the string
	 */
	@GetMapping("/")
	public String viewHomePage(Model model) {
		List<Product> listProducts = service.listAll();
		model.addAttribute("listProducts", listProducts);
		
		return "index";
	}
	
	/**
	 * Show new product page.
	 *
	 * @param model the model
	 * @return the string
	 */
	@GetMapping("/new")
	public String showNewProductPage(Model model) {
		Product product = new Product();
		model.addAttribute("product", product);
		
		return "new_product";
	}
	
	/**
	 * Save product.
	 *
	 * @param product the product
	 * @return the string
	 */
	@PostMapping(value = "/save")
	public String saveProduct(@ModelAttribute("product") Product product) {
		service.save(product);
		
		return "redirect:/";
	}
	
	/**
	 * Show edit product page.
	 *
	 * @param id the id
	 * @return the model and view
	 */
	@GetMapping("/edit/{id}")
	public ModelAndView showEditProductPage(@PathVariable(name = "id") int id) {
		ModelAndView mav = new ModelAndView("edit_product");
		Product product = service.get(id);
		mav.addObject("product", product);
		
		return mav;
	}
	
	/**
	 * Delete product.
	 *
	 * @param id the id
	 * @return the string
	 */
	@RequestMapping("/delete/{id}")
	public String deleteProduct(@PathVariable(name = "id") int id) {
		service.delete(id);
		return "redirect:/";		
	}
	
	/**
	 * Recent.
	 *
	 * @param model the model
	 * @return the string
	 */
	@GetMapping("/recent")
	public String recent(Model model) {
		List<Product> listProducts = service.recentProductList();
		model.addAttribute("listProducts", listProducts);
		
		return "recent";
	}
	
	
	/**
	 * Clear.
	 *
	 * @return the string
	 */
	@RequestMapping("/clear")
	public String clear() {
		service.flush();
		return "recent";		
	}
}
