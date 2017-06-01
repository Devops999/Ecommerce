package com.niit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.niit.dao.CategoryDao;
import com.niit.dao.ProductDao;
import com.niit.dao.SupplierDao;
import com.niit.domain.Category;
import com.niit.domain.Product;
import com.niit.domain.Supplier;

@Controller
public class AdminController {
	@Autowired
	private Category category;

	@Autowired
	private Supplier supplier;
	@Autowired
	private SupplierDao supplierdao;
	
	@Autowired
	private Product product;
	@Autowired
	private ProductDao productdao;
	

	@Autowired
	CategoryDao categorydao;

	// method 1 category
	@RequestMapping(value = "manageCategories", method = RequestMethod.GET)
	public ModelAndView RegistrationPage(Model model) {
		System.out.println("manageCategories*****");
		ModelAndView mv = new ModelAndView("adminHome");
		mv.addObject("isUserClickedCategory", "true");
		mv.addObject("category", category);
		List<Category> categoryList = categorydao.list();
		mv.addObject("categoryList", categoryList);
		return mv;
	}

	@RequestMapping(value="manageSuppliers" , method= RequestMethod.GET)
	public ModelAndView manageSupplier() {
		ModelAndView mv = new ModelAndView("adminHome");
		System.out.println("manageSuppliers*****");
		mv.addObject("isAdminClickedSuppliers", "true");
		//mv.addObject("supplier", supplier);
		List<Supplier> supplierList = supplierdao.list();
		mv.addObject("supplierList", supplierList);
		  return mv;

	}

	// method for product
	@RequestMapping(value = "manageProducts",  method= RequestMethod.GET)
	public ModelAndView manageProduct() {
		ModelAndView mv = new ModelAndView("adminHome");
		mv.addObject("isAdminClickedProduct", true);
		List<Product> productList = productdao.list();
		mv.addObject("productList", productList);
		return mv;
	}

	/*
	 * // method 2 category
	 * 
	 * @RequestMapping(value = "/manageCategories", method = RequestMethod.POST)
	 * public String registration(@Valid @ModelAttribute(name = "categoryobj")
	 * Category category, BindingResult result, Model model) {
	 * 
	 * if (result.hasErrors()) return "home"; // userDao.insert(user);// inserts
	 * into DATABASE model.addAttribute("sucess", "succesfully inserted");
	 * model.addAttribute("categoryobj", category);
	 * 
	 * return "categories"; }
	 */

	/*
	 * @RequestMapping("/manageCategories") public ModelAndView
	 * manageCategories() {
	 * 
	 * log.debug("Starting of the method manageCategories");
	 * 
	 * ModelAndView mv = new ModelAndView("home");
	 * mv.addObject("isAdminClickedCategories", "true"); mv.addObject("isAdmin",
	 * "true");
	 * 
	 * log.debug("End of the method manageCategories"); return mv;
	 * 
	 * 
	 * }
	 */

	

}
