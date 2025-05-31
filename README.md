# Capstone

This document describes the available endpoints for managing products and shopping carts.

---

## 📦 Product Endpoints
All enpoints return string with meesages of the requested API's status.

### GET /Products/listAll

- *Description:* Retrieves a list of all available products.

---

### GET /Products/search?id=&name=

- *Description:* Searches for products by id, name. Note that one name or id must be provided.
- *Query Parameters:*
  - id (optional): Product ID.
  - name (optional): Product name or keyword.
- *Response:* Returns a filtered list of matching product(s).

---

## 🛒 Cart Endpoints

### POST /Carts/{cartId}/Products/{productId}

- *Description:* Adds a specific product to a specific cart.
- *Path Parameters:*
  - cartId: ID of the cart.
  - productId: ID of the product to add.

---

### DELETE /Carts/{cartId}/Products/{productId}

- *Description:* Removes a specific product from a specific cart.
- *Path Parameters:*
  - cartId: ID of the cart.
  - productId: ID of the product to remove.

---

### GET /Carts/{cartId}/show

- *Description:* Displays the current contents of a specific cart.
- *Path Parameter:*
  - cartId: ID of the cart.
- *Response:* List of products in the cart, including quantities and totals.

---

### PUT /Carts/{cartId}/clear

- *Description:* Clears all products from the cart.
- *Path Parameter:*
  - cartId: ID of the cart to clear.

---

### PUT /Carts/{cartId}/pay

- *Description:* Finalizes the purchase and processes payment for the cart.
- *Path Parameter:*
  - cartId: ID of the cart to pay for.
