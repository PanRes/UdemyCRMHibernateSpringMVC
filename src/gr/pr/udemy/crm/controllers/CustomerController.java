package gr.pr.udemy.crm.controllers;

import gr.pr.udemy.crm.dao.CustomerDAO;
import gr.pr.udemy.crm.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	private CustomerDAO customerDAO;
	
	@RequestMapping("/list")
	public String listOfCustomers(Model model) {
		
		List<Customer> customers = customerDAO.getAllCustomers();
		
		model.addAttribute("customers",customers);
		
		return "listOfCustomers";
	}
	
}
