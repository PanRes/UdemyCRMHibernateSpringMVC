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
	
	public List<Customer> getAllCustomers() {
		Session session = sessionFactory.getCurrentSession();
		
		Query query = session.createQuery("from Customer order by lastName", Customer.class);
		
		List <Customer> customers = query.getResultList();
		
		return customers;
	}
	
	public Customer getCustomerById(int id) {
		Session session = sessionFactory.getCurrentSession();
		
		Customer customer = session.get(Customer.class,id);
		
		return customer;
	}
	
	public Customer deleteCustomerById(int id) {
		Session session = sessionFactory.getCurrentSession();
		
		Customer customer = session.get(Customer.class,id);
		
		session.delete(customer);
		
		return customer;
	}
	
	public void saveCustomer(Customer customer) {
		Session session = sessionFactory.getCurrentSession();
		
		session.save(customer);
	}
	
	
}
