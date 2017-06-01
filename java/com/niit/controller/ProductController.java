package com.niit.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.niit.dao.CategoryDao;
import com.niit.dao.ProductDao;
import com.niit.dao.SupplierDao;
import com.niit.domain.Category;
import com.niit.domain.Product;
import com.niit.domain.Supplier;

@Controller
public class ProductController {
	@Autowired
	private Product product;
	@Autowired
	private ProductDao productdao;

	@Autowired
	private CategoryDao cdao;

	@Autowired
	private SupplierDao sdao;

	// displays all the Product in the table
	@RequestMapping(value = "/getAllProducts")
	public ModelAndView getAllProducts() {
		List<Product> allproducts = productdao.list();
		ModelAndView mv = new ModelAndView("product", "productList", allproducts);
		return mv;
	}

	// browse all products including Angular JS
	@RequestMapping(value = "/getProductsList")
	public @ResponseBody List<Product> getProductsListInJSON() {
		System.out.println("getProductsListInJSON called**************");
		return productdao.list();
	}

	// 1
	@RequestMapping(value = "manage_product_create", method = RequestMethod.GET)
	public ModelAndView createproductForm() {
		System.out.println("createproductForm is called**");
		ModelAndView mv = new ModelAndView("createProductForm");
		mv.addObject("createProductObj", product);

		List<Category> categoryList = cdao.list();
		List<Supplier> supplierList = sdao.list();

		System.out.println(categoryList);
		System.out.println(supplierList);
		mv.addObject("categoryList", categoryList);
		mv.addObject("supplierList", supplierList);

		return mv;

	}

	// 2
	// method 2 for addproduct
	/*
	 * @RequestMapping(value = "/admin/product/addProduct", method =
	 * RequestMethod.POST) public String addProduct(@Valid @ModelAttribute(value
	 * = "productFormObj") Product product, BindingResult result) { if
	 * (result.hasErrors()) {
	 * 
	 * return "productForm";
	 * 
	 * } else { productdao.addProduct(product);
	 * 
	 * MultipartFile productImage = product.getImage(); if (productImage != null
	 * && !productImage.isEmpty()) { Path paths = (Path) Paths .get(
	 * "F:\\Codes\\Eclipse\\Workspace_DT7_4\\spring\\src\\main\\webapp\\WEB-INF\\resources\\images\\"
	 * + product.getId() + ".png");
	 * 
	 * try { productImage.transferTo(new File(paths.toString())); } catch
	 * (IllegalStateException e) {
	 * 
	 * e.printStackTrace(); } catch (IOException e) {
	 * 
	 * e.printStackTrace(); }
	 * 
	 * }
	 * 
	 * 
	 * return "redirect:/getallproducts"; } }
	 */

	@RequestMapping(value = "manage_product_create", method = RequestMethod.POST)
	public ModelAndView createProduct(@Valid @ModelAttribute(value = "createProductObj") Product product,
			MultipartFile file, Model model, BindingResult result) {
		System.out.println("createProduct called****");
		ModelAndView mv = new ModelAndView("adminHome");
		if (result.hasErrors())
			return new ModelAndView("createProductForm");

		else {
			Category category = cdao.getCategoryByName(product.getCategory().getName());
			System.out.println(category.getId() + ":" + category.getName() + ":" + category.getDescription());
			Supplier supplier = sdao.getSupplierByName(product.getSupplier().getName());
			System.out.println(supplier.getId() + ":" + supplier.getName() + ":" + supplier.getAddress());

			product.setCategory(category);
			product.setSupplier(supplier);
			productdao.insert(product);
			mv.addObject("isUserClickedProducts", "true");
			mv.addObject("productList", productdao.list());

			MultipartFile prodImage = product.getFile();
			System.out.println(prodImage);
			if (prodImage != null || !prodImage.isEmpty()) {

				
				// store this Image
				Path paths = Paths
						.get("D:/DEV_OPS/Workspace for eclipse/EcommerceProject/src/main/webapp/WEB-INF/resources/images/"
								+ product.getId() + ".png");
				try {
					prodImage.transferTo(new File(paths.toString()));
				} catch (IllegalStateException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		return mv;

	}

	/*
	 * @SuppressWarnings("null") /* @RequestMapping(value =
	 * "manage_product_create", method = RequestMethod.POST) public ModelAndView
	 * createProduct(@Valid @ModelAttribute(name = "createProductObj") Product
	 * product, BindingResult result, @RequestParam(value = "image")
	 * MultipartFile file, Model model) {
	 * 
	 * System.out.println("createProduct called*****"); ModelAndView mv = new
	 * ModelAndView("adminHome"); if (result.hasErrors()) return new
	 * ModelAndView("createProductForm");
	 * 
	 * else {
	 * 
	 * Category category = cdao.getCategoryById(product.getCategory().getId());
	 * Supplier supplier = sdao.getSupplierById(product.getSupplier().getId());
	 * product.setCategory(category); product.setSupplier(supplier);
	 * 
	 * productdao.insert(product);// product save done
	 * 
	 * MultipartFile productimage = product.getImage();
	 * System.out.println(productimage); if (productimage != null ||
	 * !productimage.isEmpty()) {
	 * 
	 * // store this Image Path paths = Paths
	 * .get("D:\\DEV_OPS\\Workspace for eclipse\\EcommerceProject\\src\\main\\webapp\\WEB-INF\\resources\\images\\"
	 * + product.getId() + ".png"); try { productimage.transferTo(new
	 * File(paths.toString())); } catch (IllegalStateException e) {
	 * e.printStackTrace(); mv.addObject("message",
	 * "Not able to create Product.Please contact Administrator"); } catch
	 * (IOException e) { e.printStackTrace(); mv.addObject("message",
	 * "Not able to create Product.Please contact Administrator"); }
	 * mv.addObject("message", "Successfully saved the Product"); List<Product>
	 * productList = productdao.list(); mv.addObject("productList",
	 * productList); }
	 * 
	 * }
	 * 
	 * mv.addObject("isAdminClickedProduct", "true"); return mv;
	 * 
	 * }
	 */
	// for deleting the product

	@RequestMapping(value = "/manage_products_delete/{id}", method = RequestMethod.GET)
	public String deleteProduct(@PathVariable(value = "id") int id, Model model) {
		Product product = productdao.getProductById(id);
		productdao.delete(product);
		return "redirect:/getAllProducts";

	}

	// edit Category
	// method 1 for edit Categry
	@RequestMapping(value = "/manage_products_edit/{id}", method = RequestMethod.GET)
	public ModelAndView getEditProductForm(@PathVariable(value = "id") int id) {
		System.out.println("getEditForm called******");
		Product product = this.productdao.getProductById(id);
		return new ModelAndView("editProductForm", "editProductObj", product);
	}

	// edit Category
	// method 2 for edit Categry
	@RequestMapping(value = "/manage_products_edit", method = RequestMethod.POST)
	public String editProduct(@ModelAttribute(value = "editProductObj") Product product) {
		System.out.println("editProduct is called********");

		this.productdao.update(product);
		return "redirect:/getAllProducts";

	}

	// view product details if productId is clicked
	@RequestMapping(value = "/getProductsByProductId/{id}", method = RequestMethod.GET)
	public ModelAndView getProductsByProductId(@PathVariable(value = "id") int id) {
		System.out.println("getProductsByProductId called***");
		Product product = productdao.getProductById(id);
		System.out.println("getProductsByProductId called after productDAO **");
		return new ModelAndView("productPage", "product", product);
	}

}
