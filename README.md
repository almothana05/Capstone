# Capstone

This document describes the available endpoints for managing products and shopping carts.

---

## 📦 Product Endpoints

### GET /Products/listAll

- *Description:* Retrieves a list of all available products.
- *Response:* Returns an array of product objects.

---

### GET /Products/search?id=&name=

- *Description:* Searches for products by id, name, or both.
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
- *Response:* Confirmation of the product being added.

---

### DELETE /Carts/{cartId}/Products/{productId}

- *Description:* Removes a specific product from a specific cart.
- *Path Parameters:*
  - cartId: ID of the cart.
  - productId: ID of the product to remove.
- *Response:* Confirmation of the product being removed.

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
- *Response:* Confirmation that the cart has been emptied.

---

### PUT /Carts/{cartId}/pay

- *Description:* Finalizes the purchase and processes payment for the cart.
- *Path Parameter:*
  - cartId: ID of the cart to pay for.
- *Response:* Confirmation of successful payment or failure details.

---

## 📘 Notes

- All endpoints assume a RESTful design.
- Ensure appropriate authentication if needed (not covered in this documentation).
- Input validation and error responses may vary based on implementation.
