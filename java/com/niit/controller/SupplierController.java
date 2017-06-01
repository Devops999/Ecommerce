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

import com.niit.dao.SupplierDao;
import com.niit.domain.Category;
import com.niit.domain.Supplier;

@Controller
public class SupplierController {

	@Autowired
	private Supplier supplier;

	@Autowired
	private SupplierDao supplierdao;

	// displays all the Categories in the table
	@RequestMapping(value = "/getAllSuppliers")
	public ModelAndView getAllCategories() {
		List<Supplier> allsuppliers = supplierdao.list();
		ModelAndView mv = new ModelAndView("supplier", "supplierList", allsuppliers);
		return mv;
	}

	// add Supplier
	// method 1 for populating the supplier Form
	@RequestMapping(value = "manage_supplier_create", method = RequestMethod.GET)
	public ModelAndView createSupplierForm() {
		System.out.println("createSupplierForm called***");
		ModelAndView mv = new ModelAndView("createSupplierForm");
		mv.addObject("createSupplierObj", supplier);
		return mv;

	}

	@RequestMapping(value = "manage_supplier_create", method = RequestMethod.POST)
	public ModelAndView createSupplier(@Valid @ModelAttribute(name = "createSupplierObj") Supplier supplier,
			BindingResult result) {
		ModelAndView mv = new ModelAndView("adminHome");

		if (result.hasErrors())
			return new ModelAndView("createSupplierForm");
		if (supplierdao.insert(supplier)) {
			mv.addObject("message", "successsfully created the supplier");
			List<Supplier> supplierList = supplierdao.list();
			mv.addObject("supplierList", supplierList);
		} else {
			mv.addObject("message", "Not able to create supplier.Please contact Adminstration");
		}
		mv.addObject("isAdminClickedSuppliers", "true");
		return mv;
	}

	// for deleting the Supplier

	@RequestMapping(value = "/manage_supplier_delete/{id}", method = RequestMethod.GET)
	public String deleteCategory(@PathVariable(value = "id") int id, Model model) {
		Supplier supplier = supplierdao.getSupplierById(id);
		supplierdao.delete(supplier);
		return "redirect:/getAllSuppliers";

	}

	// edit Supplier
	// method 1 for edit Supplier
	@RequestMapping(value = "/manage_supplier_edit/{id}", method = RequestMethod.GET)
	public ModelAndView getEditSupplierForm(@PathVariable(value = "id") int id) {
		System.out.println("getEditForm called******");
		Supplier supplier = this.supplierdao.getSupplierById(id);
		return new ModelAndView("editSupplierForm", "editSupplierObj", supplier);
	}

	// edit Supplier
	// method 2 for edit Supplier
	@RequestMapping(value = "/manage_supplier_edit", method = RequestMethod.POST)
	public String editCategory(@ModelAttribute(value = "editSupplierObj") Supplier supplier) {
		System.out.println("editSupplier is called********");

		this.supplierdao.update(supplier);
		return "redirect:/getAllSuppliers";

	}

}
