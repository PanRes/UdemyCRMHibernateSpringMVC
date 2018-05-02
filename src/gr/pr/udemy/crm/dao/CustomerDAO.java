package gr.pr.udemy.crm.dao;

import gr.pr.udemy.crm.entity.Customer;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface CustomerDAO {
	
	@Transactional
	List<Customer> getAllCustomers();
	
	@Transactional
	Customer getCustomerById(int id);
	
	@Transactional
	Customer deleteCustomerById(int id);
}
