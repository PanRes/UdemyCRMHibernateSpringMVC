package gr.pr.udemy.crm.services;

import gr.pr.udemy.crm.entity.Customer;

import java.util.List;

public interface CustomerService {
	
	List<Customer> getAllCustomers();
	
	void saveCustomer(Customer customer);
}
