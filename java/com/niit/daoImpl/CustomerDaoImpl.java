package com.niit.daoImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.dao.CustomerDao;
import com.niit.domain.Cart;
import com.niit.domain.Customer;
import com.niit.domain.User;

@Repository
@Transactional
public class CustomerDaoImpl implements CustomerDao {

	@Autowired
	private SessionFactory sessionFactory;

	// add a customer
	public void addCustomer(Customer customer) {
		Session session = sessionFactory.openSession();
		customer.getUser().setEnabled(true);
		customer.getUser().setRole("ROLE_USER");

		Cart cart = new Cart();
		customer.setCart(cart);
		cart.setCustomer(customer);

		session.save(customer);
		session.flush();
		session.close();

	}

	public List<Customer> getAllCustomers() {
		Session session = sessionFactory.openSession();
		List<Customer> customers = session.createQuery("from Customer").list();
		return customers;

	}

	public Customer getCustomerByUsername(String username) {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from User where name=?");
		query.setString(0, username);
		User user = (User) query.uniqueResult();
		Customer customer = user.getCustomer();
		return customer;
	
	
	}

}
