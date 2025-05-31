package orgi.Requests;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestParam;
import orgi.Entities.Product;
import orgi.Entities.ProductType;
import orgi.Repositories.DAO;
import orgi.Repositories.ProductDAO;
import orgi.Repositories.ProductTypeDAO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/Products")
public class ProductRequestHandler {
    private DAO<ProductType> ptDAO;
    private DAO<Product> pDAO;

    public ProductRequestHandler(@Qualifier("ptDAO") DAO<ProductType> ptDAO , @Qualifier("pDAO") DAO<Product>pDAO){
        this.ptDAO = ptDAO;
        this.pDAO = pDAO;
    }

    @GetMapping("/listAll")
    public String listAll(){
        StringBuilder ans = new StringBuilder();
        List<ProductType> pts = ptDAO.listAll();
        for(ProductType pt : pts){
            ans.append(pt + ", Available number: " + ((ProductDAO)pDAO).getAvailableNb(pt.getId()) + "\n");
        }
        return ans.toString();
    }
    @GetMapping(value = "/search", params = "name")
    public String searchProduct(@RequestParam("name") String s){
        StringBuilder ans = new StringBuilder();
        List<ProductType> pts = ((ProductTypeDAO)ptDAO).findLike(s);
        for(ProductType pt : pts){
            ans.append(pt + ", Available number: " + ((ProductDAO)pDAO).getAvailableNb(pt.getId()) + "\n");
        }
        return ans.toString();
    }

    @GetMapping(value = "/search", params = "id")
    public String searchProduct(@RequestParam Long id){
        ProductType pt = ptDAO.findById(id);
        StringBuilder ans = new StringBuilder();
        ans.append(pt + ", Available number: " + ((ProductDAO)pDAO).getAvailableNb(pt.getId()) + "\n");
        return ans.toString();
    }

    @GetMapping(value = "/search")
    public String searchProduct(){
        return "Either id or name is required but not both";
    }
}
