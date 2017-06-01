package com.niit.daoImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.dao.CartItemDao;
import com.niit.domain.Cart;
import com.niit.domain.CartItem;

@Repository
@Transactional
public class CartItemDaoImpl implements CartItemDao {

	@Autowired
	private SessionFactory sessionFactory;

	public void addCartItem(CartItem cartItem) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.saveOrUpdate(cartItem);
		session.getTransaction().commit();
		session.flush();
		session.close();

	}

	public void removeCartItem(CartItem cartItem) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		

		session.delete(cartItem);
		
		session.getTransaction().commit();
		session.flush();
		session.close();

	}

	public void removeAllCartItems(Cart cart) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		List<CartItem> cartItems = cart.getCartItems();
		for (CartItem cartItem : cartItems) {
			//removeCartItem(cartItem.getCartItemId());

			removeCartItem(cartItem);

		}

	}

	public CartItem getCartItem(int cartItemId) {
		Session session = sessionFactory.openSession();
		CartItem cartItem = (CartItem) session.get(CartItem.class, cartItemId);
		session.flush();
		session.close();
		return cartItem;

	}

}
