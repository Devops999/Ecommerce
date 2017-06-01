
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
import com.niit.dao.SupplierDao;
import com.niit.domain.Supplier;

@Repository("sdao")
@Transactional
@Component
public class SupplierDaoImpl implements SupplierDao {
	@Autowired
	Supplier supplier;

	@Autowired
	SupplierDao supplierDao;

	@Autowired
	private SessionFactory sessionFactory;

	public List<Supplier> list() {
		Session session = (Session) sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		List<Supplier> list = session.createQuery("from Supplier").list();
		tx.commit();
		session.flush();
		session.close();
		return list;

	}

	public boolean insert(Supplier supplier) {
		try {

			System.out.println("insert is called*******");
			Session session = sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			session.save(supplier);
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

	public boolean update(Supplier supplier) {

		try {
			Session session = sessionFactory.openSession();
			Transaction tx = session.beginTransaction();

			session.saveOrUpdate(supplier);
			tx.commit();
			session.flush();
			session.close();
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
		return true;
	}

	public boolean delete(Supplier supplier) {

		try {

			// supplier supplier = supplierDao.getsupplierById(id);
			Session session = sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			session.delete(supplier);
			tx.commit();
			session.flush();// commit to the db
			session.close();

		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
		return true;
	}

	public Supplier getSupplierById(int id) {

		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();

		Supplier supplier = (Supplier) session.get(Supplier.class, id);
		tx.commit();

		session.flush();
		session.close();
		return supplier;

	}

	public Supplier getSupplierByName(String name) {
		Session session = sessionFactory.openSession();

		Query query = session.createQuery("from Supplier where name=?");
		// Query query;
		query.setString(0, name);

		return (Supplier) query.uniqueResult();

	}

}
