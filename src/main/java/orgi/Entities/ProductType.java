package orgi.Entities;

import jakarta.persistence.*;

@Entity(name = "Almothana_Alzahrani_ProductType")
@Table(name= "Almothana_Alzahrani_ProductType")
public class ProductType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    private String category;

    @Column(nullable = false)
    private Double price;

    @Column(nullable = false)
    private Double tax;

    private String description;

    public ProductType() {
    }

    public ProductType(String name, Double price, Double tax){
        this.name = name;
        this.price = price;
        this.tax = tax;
    }

    public Double getPriceWithTax(){
        return price + price * tax;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getTax() {
        return tax;
    }

    public void setTax(Double tax) {
        this.tax = tax;
    }

    @Override
    public String toString() {
        return "ProductType{" +
                "category='" + category + '\'' +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", tax=" + tax +
                ", description='" + description + '\'' +
                '}';
    }
}
