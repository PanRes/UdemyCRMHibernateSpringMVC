package gr.pr.udemy.crm.controllers;

import gr.pr.udemy.crm.entity.Customer;
import gr.pr.udemy.crm.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
	
	@PostMapping("/saveOrUpdateCustomer")
	public String saveOrUpdateCustomer(@ModelAttribute("customer") Customer customer){
		
		customerService.saveOrUpdateCustomer(customer);
		
		return "redirect:/customer/list";
	}
	
	@GetMapping("/showFormForUpdate")
	public String updateCustomerForm(@RequestParam("customerId")int id, Model model){
		
		Customer customer = customerService.getCustomerById(id);
		
		model.addAttribute("customer",customer);
		
		return "customerForm";
	}
	
	@GetMapping("/deleteCustomer")
	public String deleteCustomer(@RequestParam("customerId")int id, Model model){
		
		customerService.deleteCustomer(id);
		
		return "redirect:/customer/list";
	}
}
