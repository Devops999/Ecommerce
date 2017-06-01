package com.niit.dao;

import com.niit.domain.Cart;
import com.niit.domain.CartItem;

public interface CartItemDao {

	void addCartItem(CartItem cartItem);

	void removeCartItem(CartItem cartItemId);

	void removeAllCartItems(Cart cart);

	CartItem getCartItem(int cartItemId);
}
