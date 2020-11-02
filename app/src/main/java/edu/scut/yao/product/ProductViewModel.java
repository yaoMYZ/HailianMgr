package edu.scut.yao.product;

import java.util.ArrayList;
import java.util.List;

import edu.scut.yao.pojo.Product;

public class ProductViewModel{


    public ProductViewModel() {
    }

    public List<Product> getProducts(){
        List<Product> products = new ArrayList<>();
        for (int i=0;i <100;i++) {
            Product new_product = new Product();
            new_product.setDescription("这是个样例");
            new_product.setName("样例"+ i);
            products.add(new_product);
        }
        return products;
    }
}