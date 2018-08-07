package gr.pr.udemy.crm.dao;

import gr.pr.udemy.crm.entity.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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
		
		return session.get(Customer.class,id);
	}
	
	public void deleteCustomerById(int id) {
		Session session = sessionFactory.getCurrentSession();
		
		Query theQuery =
				session.createQuery("delete from Customer where id=:customerId");
		theQuery.setParameter("customerId", id);
		
		theQuery.executeUpdate();
	}
	
	public void saveOrUpdateCustomer(Customer customer) {
		Session session = sessionFactory.getCurrentSession();
		
		session.saveOrUpdate(customer);
	}
	
}
