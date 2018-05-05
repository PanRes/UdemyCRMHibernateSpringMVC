package gr.pr.udemy.crm.dao;

import gr.pr.udemy.crm.entity.Customer;

import java.util.List;

public interface CustomerDAO {
	
	List<Customer> getAllCustomers();
	
	Customer getCustomerById(int id);
	
	void deleteCustomerById(int id);
	
	void saveOrUpdateCustomer(Customer customer);
}
