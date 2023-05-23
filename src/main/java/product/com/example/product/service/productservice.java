package product.com.example.product.service;

import org.springframework.stereotype.Service;
import product.com.example.product.model.product;

import java.util.ArrayList;
import java.util.List;

@Service
public class productservice {
    private List<product> listProduct = new ArrayList<>();

    public productservice(){}

    public  void add(product model){
        listProduct.add(model);
    }

    public List<product> getAll(){
        return listProduct;
    }

    public product get(int id){
        return listProduct.stream().filter(p->p.getId()==id).findFirst().orElse(null);
    }

}
