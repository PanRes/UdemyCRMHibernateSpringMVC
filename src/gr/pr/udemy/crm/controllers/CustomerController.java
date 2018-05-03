package gr.pr.udemy.crm.controllers;

import gr.pr.udemy.crm.entity.Customer;
import gr.pr.udemy.crm.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/list")
	public String listOfCustomers(Model model) {
		
		List<Customer> customers = customerService.getAllCustomers();
		
		model.addAttribute("customers",customers);
		
		return "listOfCustomers";
	}
	
	@GetMapping("/showFormForAdd")
	public String addCustomer(Model model){
		
		Customer customer = new Customer();
		
		model.addAttribute("customer",customer);
		
		return "customerForm";
	}
	
	@PostMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute("customer") Customer customer){
		
		customerService.saveCustomer(customer);
		
		return "redirect:/customer/list";
	}
}
