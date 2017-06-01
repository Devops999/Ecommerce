package com.niit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.niit.dao.CartDao;
import com.niit.dao.CartItemDao;
import com.niit.dao.CustomerDao;
import com.niit.dao.ProductDao;
import com.niit.domain.Cart;
import com.niit.domain.CartItem;
import com.niit.domain.Customer;
import com.niit.domain.Product;

@Controller
public class CartItemController {

	@Autowired
	private CustomerDao cdao;

	@Autowired
	private ProductDao productDAO;

	@Autowired
	private CartItemDao cartItemdao;

	@Autowired
	private CartDao cartdao;

	@RequestMapping(value = "cart/add/{productId}")
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void addCartItem(@PathVariable(value = "productId") int productId) {

		System.out.println("addCartItem controller****************");
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String username = user.getUsername();
		Customer customer = cdao.getCustomerByUsername(username);
		Cart cart = customer.getCart();
		List<CartItem> cartItems = cart.getCartItems();

		Product product = productDAO.getProductById(productId);
		for (int i = 0; i < cartItems.size(); i++) {
			CartItem cartItem = cartItems.get(i);
			if (product.getId() == cartItem.getProduct().getId()) {
				cartItem.setQuantity(cartItem.getQuantity() + 1);// increment
																	// the
																	// quantity
				cartItem.setTotalPrice(cartItem.getQuantity() * product.getPrice());// update
																					// the
																					// total
																					// price
				cartItemdao.addCartItem(cartItem);// update the quantity in the
													// cartitem

			}

		}

		CartItem cartItem = new CartItem();
		cartItem.setQuantity(1);
		cartItem.setProduct(product);// set product id
		cartItem.setTotalPrice(product.getPrice() * 1);
		cartItem.setCart(cart);// set cart id
		cartItemdao.addCartItem(cartItem);// insert query

		// model.addAttribute("cart", cart);

		// return "cart";

		return;

	}

	@RequestMapping(value = "/cart/removecartitem/{cartItemId}")
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void removeCartItem(@PathVariable(value = "cartItemId") int cartItemId) {

		System.out.println("removeCartItem is called******************************************************");
		CartItem cartItem = cartItemdao.getCartItem(cartItemId);
		cartItemdao.removeCartItem(cartItem);
	}

	@RequestMapping("/cart/removeAllItems/{cartId}")
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void removeAllCartItem(@PathVariable(value = "cartId") int cartId) {
		Cart cart = cartdao.getCartByCartId(cartId);
		cartItemdao.removeAllCartItems(cart);
		return;
	}
}
