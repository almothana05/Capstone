package orgi.Entities;

import jakarta.persistence.*;

@Entity(name = "Almothana_Alzahrani_Product")
@Table(name = "Almothana_Alzahrani_Product")
public class Product {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "type" , nullable = false)
    private ProductType type;

    @ManyToOne
    private ShoppingCart cart;
    public Product(){
    }
    public Product(ProductType type){
        this.type = type;
    }


    public ShoppingCart getCart() {
        return cart;
    }

    public void setCart(ShoppingCart cart) {
        this.cart = cart;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ProductType getType() {
        return type;
    }

    public void setType(ProductType type) {
        this.type = type;
    }

    @Override
    public String toString() {
        String cart = null;
        if(this.cart != null){
            cart = "(" +this.cart.getId() + ", " + this.cart.getOwnerName() + ")";
        }

        return "Product{" +
                "cart=" + cart +
                ", id=" + this.type.getId() +
                ", type=" + this.type.getName() +
                '}';
    }
}
