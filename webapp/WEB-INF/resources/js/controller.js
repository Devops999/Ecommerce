var myapp = angular.module("myapp", []).controller(
		"productController",
		function($scope, $http) {
			
			// To get all products
			$scope.getAllProducts = function() {
				alert('entering the getAllProducts ***');
				$http.get('http://localhost:2080/EcommerceProject/getProductsList').success(function(data) {
					$scope.products = data;
				})
			}

			// to add a Product to the cart
			$scope.addToCart = function(productId) {
				alert('entering the addToCart **');
				$http.put('http://localhost:2080/EcommerceProject/cart/add/'+ productId).success(function() {
							alert('Product Added Successfully');
						})
			}

			// to refresh the cart
			$scope.refreshCart = function(cartId) {
				alert("entering the refresh cart");
				$http.get('http://localhost:2080/EcommerceProject/cart/getCart/'
								+ cartId).success(function(data) {
					$scope.cart = data;
					console.log(data);
				})
			}
			
			

			// to get the cart
			$scope.getCart = function(cartId) {
				alert("entering the getCart");
				$scope.cartId = cartId;
				$scope.refreshCart(cartId);
			}

			// to remove a product o from the cart
			$scope.removeFromCart = function(cartItemId) {
				
				alert('removeFromCart called***');
				$http.put('http://localhost:2080/EcommerceProject/cart/removecartitem/'+cartItemId).success(function() {
							console.log("cartItemId deleted**************");
							$scope.refreshCart($scope.cartId);
				})
			}

			// to clear the cart
			$scope.clearCart = function(cartId) {
				$http.put('http://localhost:2080/EcommerceProject/cart/removeAllItems/'+ cartId).success(function() {
					$scope.refreshCart($scope.cartId);
				});
			}

			// to calculate total price
			$scope.calculateGrandTotal = function() {
				alert("calculateGrandTotal**");
				var grandTotal = 0.0
				for (var i = 0; i < $scope.cart.cartItems.length; i++) {
					grandTotal = grandTotal
							+ $scope.cart.cartItems[i].totalPrice;
				}

				return grandTotal;
			}

		});
