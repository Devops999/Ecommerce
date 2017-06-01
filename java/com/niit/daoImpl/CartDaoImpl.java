package com.niit.daoImpl;

import java.io.IOException;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.dao.CartDao;
import com.niit.domain.Cart;

@Repository()
@Transactional
public class CartDaoImpl implements CartDao {

	@Autowired
	private SessionFactory sessionFactory;

	public Cart getCartByCartId(int cartId) {

		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Cart cart = (Cart) session.get(Cart.class, cartId);
		System.out.println(cart.getCartId() + " " + cart.getCartItems());
		session.getTransaction().commit();
		session.flush();
		session.close();
		return cart;

	}

	public Cart validate(int cartId) throws IOException {

		System.out.println("cart Validate Called****");
		Cart cart = getCartByCartId(cartId);
		if (cart == null || cart.getCartItems().size() == 0) {
			throw new IOException(cartId + "");
		}

		//update(cart);
		System.out.println("cart updated****");
		return cart;

	}

}
