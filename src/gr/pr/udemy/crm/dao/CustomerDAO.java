package gr.pr.udemy.crm.dao;

import gr.pr.udemy.crm.entity.Customer;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface CustomerDAO {
	
	List<Customer> getAllCustomers();
	
	Customer getCustomerById(int id);
	
	Customer deleteCustomerById(int id);
	
	void saveCustomer(Customer customer);
}
