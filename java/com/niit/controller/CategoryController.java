package com.niit.controller;

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
import org.springframework.web.servlet.ModelAndView;

import com.niit.dao.CategoryDao;
import com.niit.domain.Category;

@Controller
public class CategoryController {

	@Autowired
	CategoryDao categorydao;

	@Autowired
	Category category;

	// displays all the Categories in the table
	@RequestMapping(value = "/getAllCategories")
	public ModelAndView getAllCategories() {
		List<Category> allcategories = categorydao.list();
		ModelAndView mv = new ModelAndView("category", "categoryList", allcategories);
		//ModelAndView mv=new ModelAndView(viewName, mapstring,model)
		return mv;
	}

	// add Category
	// method 1 for populating the Category Form
	@RequestMapping(value = "/manage_category_create", method = RequestMethod.GET)
	public ModelAndView createcategoryForm() {
		System.out.println("createcategoryForm is called**");
		ModelAndView mv = new ModelAndView("createCategoryForm");
		mv.addObject("createCategoryObj", category);
		return mv;

	}

	@RequestMapping(value = "/manage_category_create", method = RequestMethod.POST)
	public ModelAndView createCategory(@Valid @ModelAttribute(name = "createCategoryObj") Category category,
			BindingResult result) {
		ModelAndView mv = new ModelAndView("adminHome");
		if (result.hasErrors())
			return new ModelAndView("createCategoryForm");

		if (categorydao.insert(category)) {

			mv.addObject("message", "Successfully created the category");
			List<Category> categoryList = categorydao.list();
			mv.addObject("categoryList", categoryList);
		}

		else {
			mv.addObject("message", "Not able to create Category.Please contact Administrator");

		}

		mv.addObject("isUserClickedCategory", "true");
		return mv;

	}

	// for deleting the category

	@RequestMapping(value = "/manage_categories_delete/{id}", method = RequestMethod.GET)
	public String deleteCategory(@PathVariable(value = "id") int id, Model model) {
		Category category = categorydao.getCategoryById(id);
		categorydao.delete(category);
		return "redirect:/getAllCategories";

	}

	// edit Category
	// method 1 for edit Categry
	@RequestMapping(value = "/manage_categories_edit/{id}", method = RequestMethod.GET)
	public ModelAndView getEditCategoryForm(@PathVariable(value = "id") int id) {
		System.out.println("getEditForm called******");
		Category category = this.categorydao.getCategoryById(id);
		return new ModelAndView("editCategoryForm", "editCategoryObj", category);
	}

	// edit Category
	// method 2 for edit Categry
	@RequestMapping(value = "/manage_categories_edit", method = RequestMethod.POST)
	public String editCategory(@ModelAttribute(value = "editCategoryObj") Category category) {
		System.out.println("editCategory is called********");

		this.categorydao.update(category);
		return "redirect:/getAllCategories";

	}

}