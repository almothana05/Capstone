package orgi;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import orgi.Entities.Product;
import orgi.Entities.ProductType;
import orgi.Entities.ShoppingCart;
import orgi.Repositories.DAO;
import orgi.Repositories.ProductDAO;
import orgi.Repositories.ProductTypeDAO;
import orgi.Repositories.ShoppingCartDAO;

import java.util.List;

@Component("IST")
@Qualifier("IST")
public class InitialSettingsProvider {
    DAO<ShoppingCart> scDAO;
    DAO<Product> pDAO;
    DAO<ProductType> ptDAO;

    public InitialSettingsProvider(@Qualifier("scDAO") DAO<ShoppingCart> scDAO,  @Qualifier("pDAO") DAO<Product> pDAO,  @Qualifier("ptDAO") DAO<ProductType> ptDAO){
        this.scDAO = scDAO;
        this.pDAO = pDAO;
        this.ptDAO = ptDAO;
    }
    public void stockItems(){
        List<ProductType> pts = ptDAO.listAll();
        for(ProductType pt : pts){
            int itemNb = ((ProductDAO)pDAO).getAvailableNb(pt.getId());
            while(itemNb < 10){
                Product p = new Product(pt);
                pDAO.save(p);
                itemNb++;
            }
        }
    }

    public void addTypes(){
        ProductType pt;
        if(((ProductTypeDAO)ptDAO).findName("t-shirt").size() == 0) {
            pt = new ProductType("t-shirt", 55.0, 0.15);
            pt.setCategory("Clothes");
            pt.setDescription("very nice red T-shirt. comes in different sizes");
            ptDAO.save(pt);
        }

        if(((ProductTypeDAO)ptDAO).findName("jeans").size() == 0) {
            pt = new ProductType("jeans", 35.0, 0.15);
            pt.setCategory("Clothes");
            pt.setDescription("good jeans. blue color, and very modest");
            ptDAO.save(pt);
        }

        if(((ProductTypeDAO)ptDAO).findName("jacket").size() == 0) {
            pt = new ProductType("jacket", 37.75, 0.15);
            pt.setCategory("Clothes");
            pt.setDescription("Jacket with colors blue, red, green");
            ptDAO.save(pt);
        }

        if(((ProductTypeDAO)ptDAO).findName("skinny jeans").size() == 0) {
            pt = new ProductType("skinny jeans" , 24.99, 0.15);
            pt.setCategory("Clothes");
            pt.setDescription("special kind of jeans. very trendy 15 years ago");
            ptDAO.save(pt);
        }

        if(((ProductTypeDAO)ptDAO).findName("hat").size() == 0) {
            pt = new ProductType("hat", 15.0, 0.15);
            pt.setCategory("Clothes");
            pt.setDescription("A classical hat");
            ptDAO.save(pt);
        }

        if(((ProductTypeDAO)ptDAO).findName("classical watch").size() == 0) {
            pt = new ProductType("classical watch", 79.99, 0.15);
            pt.setCategory("Accessory");
            pt.setDescription("A classical watch");
            ptDAO.save(pt);
        }

        if(((ProductTypeDAO)ptDAO).findName("modern watch").size() == 0) {
            pt = new ProductType("modern watch", 99.99, 0.15);
            pt.setCategory("Accessory");
            pt.setDescription("A watch that keeps track of your sleep cycle. You can pay with it, also very helpful for workouts");
            ptDAO.save(pt);
        }

        if(((ProductTypeDAO)ptDAO).findName("ring").size() == 0) {
            pt = new ProductType("ring", 300.0, 0.15);
            pt.setCategory("Accessory");
            pt.setDescription("A nice ring. made with diamond and rubies");
            ptDAO.save(pt);
        }

        if(((ProductTypeDAO)ptDAO).findName("hot dog").size() == 0) {
            pt = new ProductType("hot dog", 10.0, 0.15);
            pt.setCategory("Foods and Beverages");
            pt.setDescription("A delicious hot dog");
            ptDAO.save(pt);
        }

        if(((ProductTypeDAO)ptDAO).findName("shawerma").size() == 0) {
            pt = new ProductType("shawerma", 9.0, 0.15);
            pt.setCategory("Foods and Beverages");
            pt.setDescription("Easily top 3 foods you can eat in your whole life ");
            ptDAO.save(pt);
        }

        if(((ProductTypeDAO)ptDAO).findName("shawerma saroukh").size() == 0) {
            pt = new ProductType("shawerma saroukh", 13.0, 0.15);
            pt.setCategory("Foods and Beverages");
            pt.setDescription("shawerma but much better(basically a rocket size shawerma)");
            ptDAO.save(pt);
        }

        if(((ProductTypeDAO)ptDAO).findName("water").size() == 0) {
            pt = new ProductType("water", 1.0, 0.15);
            pt.setCategory("Foods and Beverages");
            pt.setDescription("Basic but needed");
            ptDAO.save(pt);
        }

        if(((ProductTypeDAO)ptDAO).findName("soda").size() == 0) {
            pt = new ProductType("soda", 4.0, 0.15);
            pt.setCategory("Foods and Beverages");
            pt.setDescription("Refreshing and has delicious");
            ptDAO.save(pt);
        }

        if(((ProductTypeDAO)ptDAO).findName("ice tea").size() == 0) {
            pt = new ProductType("ice tea", 4.0, 0.15);
            pt.setCategory("Foods and Beverages");
            pt.setDescription("most refreshing drink in the world");
            ptDAO.save(pt);
        }
    }

    public void addCarts(){
        ShoppingCart sc;
        if(((ShoppingCartDAO)scDAO).findOwner("Almothana").size() == 0) {
            sc = new ShoppingCart("Almothana");
            scDAO.save(sc);
            System.out.println("added Almothana");
        }


        if(((ShoppingCartDAO)scDAO).findOwner("Mohammed").size() == 0) {
            sc = new ShoppingCart("Mohammed");
            scDAO.save(sc);
            System.out.println("added Mohammed");
        }


        if(((ShoppingCartDAO)scDAO).findOwner("Almot").size() == 0) {
            sc = new ShoppingCart("Almot");
            scDAO.save(sc);

            System.out.println("added Almot");
        }
    }

    public void makeSettings(){
        System.out.println("Making settings");
        addTypes();
        stockItems();
        addCarts();
    }



}
