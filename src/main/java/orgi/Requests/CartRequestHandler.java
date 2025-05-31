package orgi.Requests;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import orgi.Entities.Product;
import orgi.Entities.ShoppingCart;
import orgi.Repositories.DAO;
import orgi.Repositories.ProductDAO;

@RestController
@RequestMapping("/Carts")
public class CartRequestHandler {
    private DAO<ShoppingCart> scDAO;
    private DAO<Product>  pDAO;

    public CartRequestHandler(@Qualifier("scDAO") DAO<ShoppingCart> scDAO , @Qualifier("pDAO") DAO<Product> pDAO){
        this.scDAO = scDAO;
        this.pDAO = pDAO;
    }

    @PostMapping("/{cartId}/Products/{productId}")
    public String addProductToCart(@PathVariable Long cartId, @PathVariable("productId") Long productTypeId){
        ShoppingCart sc = scDAO.findById(cartId);
        Product p = ((ProductDAO)pDAO).getProductByType(productTypeId);
        if(sc == null || p == null){
            return "Either cart or product id is invalid";
        }
        sc.addProduct(p);
        scDAO.save(sc);
        pDAO.save(p);
        return "Product added successfully to cart";
    }

    @DeleteMapping("/{cartId}/Products/{productId}")
    public String removeProductFromCart(@PathVariable Long cartId , @PathVariable("productId") Long productTypeId){
        ShoppingCart sc = scDAO.findById(cartId);
        Product p = ((ProductDAO)pDAO).getProductByTypeAndCart(productTypeId , cartId);
        if(sc == null || p == null){
            return "Either cart or product id is invalid";
        }
        sc.removeProduct(p);
        scDAO.save(sc);
        pDAO.save(p);
        return "Product removed successfully";
    }

    @GetMapping("/{cartId}/show")
    public String showCart(@PathVariable Long cartId){
        StringBuilder ans = new StringBuilder();
        ShoppingCart sc = scDAO.findById(cartId);
        if(sc == null){
            return "Invalid cart id";
        }
        ans.append("Cart of " + sc.getOwnerName() + ": " + "\n");
        for(Product p : sc.getProducts()){
            ans.append(p + "\n");
        }
        return ans.toString();
    }

    @PutMapping("/{cartId}/clear")
    public String clearCart(@PathVariable Long cartId){
        ShoppingCart sc = scDAO.findById(cartId);
        if(sc == null){
            return "Invalid cart id";
        }
        sc.clear();
        scDAO.save(sc);
        return "Cart have been cleared";
    }

    @PutMapping("/{cartId}/pay")
    public String pay(@PathVariable Long cartId){
        StringBuilder ans = new StringBuilder();
        ShoppingCart sc = scDAO.findById(cartId);
        if(sc == null){
            return "Invalid cart id";
        }
        double price = sc.getPrice();
        for(Product p: sc.getProducts()){

            ans.append(p + ", price with tax: " + p.getType().getPriceWithTax() + "\n");
        }
        ans.append("--------------------------------\n");
        ans.append("total price: " + price + "\n");
        while (!sc.getProducts().isEmpty()){
            pDAO.removeById(sc.getProducts().get(0).getId());
            sc.getProducts().remove(sc.getProducts().get(0));
        }
        scDAO.save(sc);
        return ans.toString();

    }


}
