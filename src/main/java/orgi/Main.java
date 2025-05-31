package orgi;

import org.springframework.context.ApplicationContext; // ✅ CORRECT

import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
@EnableTransactionManagement
public class Main {






    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(Main.class, args);
        InitialSettingsProvider ist = (InitialSettingsProvider) context.getBean("IST");
        ist.makeSettings();
//        Main.addTypers(ptDAO);
//        EntityManagerFactory emf = Persistence.createEntityManagerFactory("myJpaUnit");
//        EntityManager em = emf.createEntityManager();

//        DAO<ProductType> ptDAO = new ProductTypeDAO(em);
//        DAO<ShoppingCart> scDAO = new ShoppingCartDAO(em);
//        DAO<Product> pDAO = new ProductDAO(em);
//
//        ProductRequestHandler prh = new ProductRequestHandler(ptDAO , pDAO);
//        CartRequestHandler crh = new CartRequestHandler(scDAO, pDAO);

//        prh.listAll();

//        pDAO.save(new Product(ptDAO.findById(1L)));
//        pDAO.save(new Product(ptDAO.findById(1L)));
//        pDAO.save(new Product(ptDAO.findById(1L)));
//
//        crh.addProductToCart(1L, 1L);
//        crh.removeProductFromCart(1L , 1L);
//        crh.pay(1L);
//        crh.showCart(1L);
//        crh.clearCart(1L);
//        System.out.println(((ProductDAO)pDAO).getProductByType(1L));
//        System.out.println(((ProductDAO)pDAO).getAvailableNb(1L));





//        ProductType pt = new ProductType("dog" , 1.5, 0.15);
//        ptDAO.save(pt);
//        prh.searchProduct("doggy");

////        Product p = new Product(ptDAO.findById(1L));
////        pDAO.save(p);
//        System.out.println("products:");
//        List<Product> ps = pDAO.listAll();
//        for(Product py : ps){
//            System.out.println(py );
//        }
//
////        ShoppingCart s = new ShoppingCart("Almothana");
////        scDAO.save(s);
////        ShoppingCart s = scDAO.findById(1L);
////        Product p = pDAO.findById(1L);
////        s.removeProduct(p);
////        scDAO.save(s);
////        pDAO.save(p);;
//
//
//
//        System.out.println("shopping carts:");
//        List<ShoppingCart> scs = scDAO.listAll();
//        for(ShoppingCart scy : scs){
//            System.out.println(scy.getId() + " " + scy.getOwnerName() + " " + scy.getProducts().size());
//        }

    }
}