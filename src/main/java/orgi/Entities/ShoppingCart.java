package orgi.Entities;

import jakarta.persistence.*;

import java.util.List;

@Entity(name = "Almothana_Alzahrani_ShoppingCart")
@Table(name= "Almothana_Alzahrani_ShoppingCart")
public class ShoppingCart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String ownerName;

    @OneToMany(mappedBy = "cart")
    private List<Product> products;

    public ShoppingCart(){

    }
    public ShoppingCart(String ownerName){
        this.ownerName = ownerName;
    }

    public void addProduct(Product p){// who should save in database
        products.add(p);
        p.setCart(this);
    }

    public void removeProduct(Product product) {
        products.remove(product);
        product.setCart(null);
    }

    public void clear(){
        while(!products.isEmpty()){
            removeProduct(products.get(0));
        }
    }

    public double getPrice(){
        double pr = 0.0;
        for(Product product : products){
            ProductType pt = product.getType();
            pr += pt.getPrice() + pt.getPrice() * pt.getTax();
        }
        return pr;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public List<Product> getProducts() {
        return products;
    }
}
