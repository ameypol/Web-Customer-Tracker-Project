package com.luv2code.springdemo.entity;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.luv2code.springdemo.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	// need to inject DAO
	
	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/list")
	public String listCustomers(Model theModel){
		
		// get customers from dao
	List<Customer> theCustomers = customerService.getCustomers();
		
	   // need to pass to jsp through model
		theModel.addAttribute("customers",theCustomers);
		
		return "list-customers";
	}
	
	@GetMapping("/customerform")
	public String showFormForAdd(Model theModel){
		
		Customer theCustomer = new Customer();
		// create model attribute to bind form data
		theModel.addAttribute("customer", theCustomer);
		return "customer-form";
	}
	
	@PostMapping("/saveCustomer")
	public String saveCoustomer(@ModelAttribute("customer") Customer theCustomer){
		
		// pass value to service for saving
		customerService.saveCustomer(theCustomer);
		
		
		return "redirect:list";
	}
	
	@GetMapping("/showFormForUpdate")
	public String saveCoustomer(@RequestParam("customerId") int theId,
								 Model theModel){
		// get customer from service
		Customer theCustomer = customerService.getCustomers(theId);
		
		// set customer model to pre-populate the form
		theModel.addAttribute("customer",theCustomer);
		
		// pass value to service for savein
		return "customer-form";
	}
	
	@GetMapping("/deleteFormForUpdate")
	public String deleteCoustomer(@RequestParam("customerId") int theId){
		// get customer from service
		customerService.deleteCustomers(theId);
		
		// redirect to list
		return "redirect:/customer/list";
	}
	
	
}
