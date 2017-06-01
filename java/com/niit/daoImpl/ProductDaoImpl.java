package com.niit.daoImpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.niit.dao.ProductDao;
import com.niit.domain.Product;
import com.niit.domain.Supplier;

@Repository("productdao")
@Transactional
@Component
public class ProductDaoImpl implements ProductDao {

	@Autowired
	Product product;

	@Autowired
	ProductDao productDao;

	@Autowired
	private SessionFactory sessionFactory;

	public List<Product> list() {

		Session session = (Session) sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		Query query = session.createQuery("from Product");
		List<Product> list = (List<Product>) query.list();

		tx.commit();
		session.flush();
		session.clear();
		session.close();
		return list;

	}

	public boolean insert(Product Product) {
		try {

			System.out.println("insert is called*******");
			Session session = sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			session.save(Product);
			tx.commit();
			session.flush();
			session.close();
			return true;

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean update(Product product) {

		try {
			Session session = sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			session.update(product);
			tx.commit();
			session.flush();
			session.close();
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
		return true;
	}

	public boolean delete(Product product) {

		try {

			// Product Product = ProductDao.getProductById(id);
			Session session = sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			session.delete(product);
			tx.commit();
			session.flush();// commit to the db
			session.close();

		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
		return true;
	}

	public Product getProductById(int id) {
		// TODO Auto-generated method stub

		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		Product product = (Product) session.get(Product.class, id);
		tx.commit();
		session.flush();
		session.close();
		return product;
	}

	public Product getProductByName(String name) {
		// TODO Auto-generated method stub
		Query query = sessionFactory.getCurrentSession().createQuery("from Product where name=?");
		// Query query;
		query.setString(0, name);
		return (Product) query.uniqueResult();
	}

}
