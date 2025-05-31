package orgi.Repositories;
import jakarta.persistence.*;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import orgi.Entities.Product;

import java.util.List;
@Component("pDAO")
@Qualifier("pDAO")
@Transactional
public class ProductDAO implements DAO<Product>{

    private EntityManager em;
    private static String tableName = "Almothana_Alzahrani_Product";

    public ProductDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Product p){
        em.merge(p);
    }

    public Product findById(Long id){
        return em.find(Product.class, id);
    }

    public List<Product> listAll(){
        TypedQuery<Product> query = em.createQuery("SELECT p from " + tableName + " p", Product.class);
        List<Product> l = query.getResultList();
        return l;
    }

    public void removeTuple(Product p){
        Product p1 = findById(p.getId());
        if(p1 != null){
            em.remove(p1);
        }
    }
    public void removeById(Long id){
        Product p1 = findById(id);
        if(p1 != null){
            em.remove(p1);
        }
    }

    public Product getProductByType(Long id){
        TypedQuery<Product> query = em.createQuery("SELECT p from " + tableName + " p WHERE p.type.id = " + id + " AND p.cart IS NULL", Product.class);
        List<Product> l = query.getResultList();
        if(l.isEmpty()){
            return null;
        }
        return l.get(0);
    }

    public Product getProductByTypeAndCart(Long typeId, Long cartId){
        TypedQuery<Product> query = em.createQuery("SELECT p from " + tableName + " p WHERE p.type.id = " + typeId + " AND p.cart.id = " + cartId, Product.class);
        List<Product> l = query.getResultList();
        if(l.isEmpty()){
            return null;
        }
        return l.get(0);
    }

    public int getAvailableNb(Long id){
        TypedQuery<Product> query = em.createQuery("SELECT p from " + tableName + " p WHERE p.type.id = " + id + " AND p.cart IS NULL", Product.class);
        List<Product> l = query.getResultList();
        return l.size();
    }
}
