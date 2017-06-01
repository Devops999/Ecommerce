
package com.niit.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.niit.dao.CustomerDao;
import com.niit.dao.UserDao;
import com.niit.domain.BillingAddress;
import com.niit.domain.Category;
import com.niit.domain.Customer;
import com.niit.domain.Product;
import com.niit.domain.ShippingAddress;
import com.niit.domain.Supplier;
import com.niit.domain.User;

@Controller
public class UserController {
	@Autowired
	UserDao userDao;

	@Autowired
	User user;

	@Autowired
	HttpSession session;

	@Autowired
	private Category category;

	@Autowired
	private Supplier supplier;

	@Autowired
	private Product product;

	
	@Autowired
	private CustomerDao cdao;

	//Old Registration Module
	/*// method 1 register
	@RequestMapping(value = "/registration", method = RequestMethod.GET)
	public String RegistrationPage(Model model) {
		// model.addAttribute("isUserClickedRegistration", "true");
		model.addAttribute("userobj", user);
		return "registration";
	}

	// method 2 register
	@RequestMapping(value = "/registration", method = RequestMethod.POST)
	public String registration(@Valid @ModelAttribute(name = "userobj") User user, BindingResult result, Model model) {

		if (result.hasErrors())
			return "registration";
		userDao.insert(user);// inserts into DATABASE
		model.addAttribute("regsucess", "Registered Successfully. Login using username and password");
		model.addAttribute("loginobj", user);

		return "login";
	}
	
	
	*/
	//New Registration Module
	 // To display registration form
	@RequestMapping(value = "/customer/registration", method = RequestMethod.GET)
	public ModelAndView getRegistrationForm() {
		Customer customer = new Customer();
		User user = new User();
		
		BillingAddress billingAddress = new BillingAddress();
		ShippingAddress shippingAddress = new ShippingAddress();

		customer.setUser(user);
		customer.setBillingAddress(billingAddress);
		customer.setShippingAddress(shippingAddress);
		return new ModelAndView("registrationCustomer", "customer", customer);

	}

	
	
	
	// to insert the data
	@RequestMapping(value = "/customer/registration", method = RequestMethod.POST)
	public String registerCustomer(@Valid @ModelAttribute(value = "customer") Customer customer, BindingResult result,
			Model model) {
		if (result.hasErrors())
			return "registrationCustomer";

		
		cdao.addCustomer(customer);
		model.addAttribute("registration success", "Registered Successfully. Login using username and password");
		return "login";
	}

	
	
	
	
	
	
	
	
	
	
	

	/*// method 1 Login
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginPage(Model model) {
		model.addAttribute("loginobj", user);
		return "login";
	}

	// method 2 Login
	@RequestMapping("/validate")
	public ModelAndView login(@Valid @ModelAttribute(name = "loginobj") User user, BindingResult result) {
		ModelAndView mv = new ModelAndView("login");

		if (result.hasErrors())
			return mv;

		if (userDao.validate(user.getName(), user.getPassword()) == true) {
			user = userDao.get(user.getName());// to get the User
			mv.addObject("message", "welcome" + user.getName());
		
			if (user.getRole().equals("ROLE_ADMIN")) {
				//mv.addObject("isAdmin", "true");
				return mv = new ModelAndView("adminHome");
			} else {
				mv.addObject("isAdmin", "false");
			
				return mv = new ModelAndView("home");
			}

		}

		else {
			mv.addObject("invalidCredentials", "true");
			mv.addObject("errorMessage", "Invalid Credentials");

			return mv;
		}

	}
*/
	

	@RequestMapping("/login")
	public String login(@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "logout", required = false) String logout, Model model) {
		if (error != null)
			model.addAttribute("error", "Invalid username and password... Please enter the correctly");
		if (logout != null)
			model.addAttribute("logout", "logout successfully");

		return "login";
	}





}
