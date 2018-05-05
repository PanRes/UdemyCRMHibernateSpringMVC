package gr.pr.udemy.crm.services;

import gr.pr.udemy.crm.dao.CustomerDAO;
import gr.pr.udemy.crm.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	private CustomerDAO customerDAO;
	
	@Transactional
	public List<Customer> getAllCustomers() {
		return customerDAO.getAllCustomers();
	}
	
	@Transactional
	public void saveOrUpdateCustomer(Customer customer){
		customerDAO.saveOrUpdateCustomer(customer);
	}
	
	@Transactional
	public void deleteCustomer(int id){
		customerDAO.deleteCustomerById(id);
	}
	
	@Transactional
	public Customer getCustomerById(int id) {
		return customerDAO.getCustomerById(id);
	}
	
}
