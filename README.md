# Capstone
## Database
### Entities description
This project has 3 entities ProductType, Product, ShoppingCart.
- *ProductType: Has the information about a specific product
- *Product: Is the instance of the product and all it's information is stored in a foreign key linking to ProductType
- *ShoppingCart: Contains all necssary information for a shopping cart.
- 
---

### Relationships
This project got 2 relationships between entitites.
- *Product-ProductType : required manyToOne relationship.
- *Product-ShoppingCart : optional manyToOne relationship.

## Initial settings
The project when run should initially make 14 productTypes (if not already existing in data base) and stock 10 products to each product type. all product types can be listed using the APIs.
There will be 3 shopping carts provided with id's 1,2 and 3(these don't have an api to list them ,so if you face an error and want to check you can either take a look in the database on table "Almothana_Alzahrani_ShoppingCart" or use bean "scDAO" to list them).

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
