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

import com.niit.dao.CategoryDao;
import com.niit.domain.Category;

@Repository("cdao")
@Transactional
@Component
public class CategoryDaoImpl implements CategoryDao {
	@Autowired
	Category category;

	@Autowired
	CategoryDao categoryDao;

	@Autowired
	private SessionFactory sessionFactory;

	public List<Category> list() {
		Session session = (Session) sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		List<Category> list = session.createQuery("from Category").list();
		tx.commit();
		session.flush();
		session.close();
		return list;

	}

	public boolean insert(Category category) {
		try {

			System.out.println("Category insert is called*******");
			Session session = sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			session.save(category);
			tx.commit();
			session.flush();
			session.close();
			return true;

		} catch (Exception e) {
			// if any excpetion comes during execute of try block, catch will
			// excute
			e.printStackTrace();
			return false;
		}
	}

	public boolean update(Category category) {

		try {
			Session session = sessionFactory.openSession();
			Transaction tx = session.beginTransaction();

			session.saveOrUpdate(category);
			tx.commit();
			session.flush();
			session.close();
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
		return true;
	}

	public boolean delete(Category category) {

		try {

			Session session = sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			session.delete(category);
			tx.commit();
			session.flush();// commit to the db
			session.close();

		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
		return true;
	}

	public Category getCategoryById(int id) {

		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		Category category = (Category) session.get(Category.class, id);
		session.flush();
		session.close();
		return category;
	}

	public Category getCategoryByName(String name) {
		Query query = sessionFactory.openSession().createQuery("from Category where name=?");
		// Query query;
		query.setString(0, name);
		return (Category) query.uniqueResult();
	}

}
