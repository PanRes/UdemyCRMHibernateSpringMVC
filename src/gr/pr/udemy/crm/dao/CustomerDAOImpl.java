package gr.pr.udemy.crm.dao;

import gr.pr.udemy.crm.entity.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class CustomerDAOImpl implements CustomerDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Transactional
	public List<Customer> getAllCustomers() {
		Session session = sessionFactory.getCurrentSession();
		
		Query query = session.createQuery("from Customer", Customer.class);
		
		List <Customer> customers = query.getResultList();
		
		return customers;
	}
	
	@Transactional
	public Customer getCustomerById(int id) {
		Session session = sessionFactory.getCurrentSession();
		
		Customer customer = session.get(Customer.class,id);
		
		return customer;
	}
	
	@Transactional
	public Customer deleteCustomerById(int id) {
		Session session = sessionFactory.getCurrentSession();
		
		Customer customer = session.get(Customer.class,id);
		
		session.delete(customer);
		
		return customer;
	}
	
	
}
