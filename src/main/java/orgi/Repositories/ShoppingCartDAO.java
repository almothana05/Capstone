package orgi.Repositories;
import jakarta.persistence.*;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import orgi.Entities.ProductType;
import orgi.Entities.ShoppingCart;

import java.util.List;
@Component
@Qualifier("scDAO")
@Transactional
public class ShoppingCartDAO implements DAO<ShoppingCart>{
    @PersistenceContext
    private EntityManager em;
    private static String tableName = "Almothana_Alzahrani_ShoppingCart";



    public void save(ShoppingCart sc){
        em.merge(sc);
    }

    public ShoppingCart findById(Long id){
        return em.find(ShoppingCart.class, id);
    }

    public List<ProductType> findOwner(String s){
        List<ProductType> results = em.createQuery(
                        "SELECT e FROM " + tableName +" e WHERE e.ownerName = :name", ProductType.class)
                .setParameter("name", s)
                .getResultList();
        return  results;
    }

    public List<ShoppingCart> listAll(){
        TypedQuery<ShoppingCart> query = em.createQuery("SELECT p from " + tableName + " p", ShoppingCart.class);
        List<ShoppingCart> l = query.getResultList();
        return l;
    }

    public void removeTuple(ShoppingCart sc){
        ShoppingCart sc1 = findById(sc.getId());
        if(sc1 != null){
            em.remove(sc1);
        }
    }
    public void removeById(Long id){
        ShoppingCart sc1 = findById(id);
        if(sc1 != null){
            em.remove(sc1);
        }
    }


}
