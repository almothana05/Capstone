package orgi.Repositories;

import jakarta.persistence.*;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import orgi.Entities.ProductType;

import java.util.List;
@Component("ptDAO")
@Qualifier("ptDAO")
@Transactional
public class ProductTypeDAO implements DAO<ProductType> {
    private EntityManager em;
    private static String tableName = "Almothana_Alzahrani_ProductType";
    
    public ProductTypeDAO(EntityManager em) {
        this.em = em;
    }

    public void save(ProductType pt){
        em.merge(pt);
    }

    public ProductType findById(Long id){
        return em.find(ProductType.class, id);
    }

    public List<ProductType> findName(String s){
        List<ProductType> results = em.createQuery(
                        "SELECT e FROM " + tableName +" e WHERE e.name = :name", ProductType.class)
                .setParameter("name", s)
                .getResultList();
        return  results;
    }

    public List<ProductType> findLike(String s){
        List<ProductType> results = em.createQuery(
                        "SELECT e FROM " + tableName + " e WHERE e.name LIKE :value", ProductType.class)
                .setParameter("value", "%" + s + "%")
                .getResultList();
        return  results;
    }

    public List<ProductType> listAll(){
        TypedQuery<ProductType> query = em.createQuery("SELECT p from " + tableName + " p", ProductType.class);
        List<ProductType> l = query.getResultList();
        return l;
    }
    public void removeTuple(ProductType pt){
        ProductType pt1 = findById(pt.getId());
        if(pt1 != null){
            em.remove(pt1);
        }
    }
    public void removeById(Long id){
        ProductType pt1 = findById(id);
        if(pt1 != null){
            em.remove(pt1);
        }
    }


}
