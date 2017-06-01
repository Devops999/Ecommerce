package com.niit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

	@RequestMapping("/")
	public ModelAndView showHomePage() {
		ModelAndView mv = new ModelAndView("home");
		//mv.addObject("msg", "Welcome to ecommerce");
		return mv;
	}

	@RequestMapping("/home")
	public ModelAndView Home(Model model) {
		ModelAndView mv = new ModelAndView("home");
		
		mv.addObject("msg", "Welcome to my ecommerce Portal");
		return mv;
	}

	@RequestMapping("/aboutUs")
	public String aboutUs(Model model) {
		model.addAttribute("message", "Welcome to  about us");
		return "aboutUs";
	}

	@RequestMapping(value = "/contactUs", method = RequestMethod.POST)
	public ModelAndView contactUs() {
		ModelAndView mv = new ModelAndView("contactUs");
		// mv.addObject("contactUsObj",contactUs);
		mv.addObject("message", "Welcome to   contact us");
		return mv;
	}

}
