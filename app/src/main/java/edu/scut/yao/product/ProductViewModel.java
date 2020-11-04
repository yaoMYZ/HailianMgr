package edu.scut.yao.product;

import java.util.ArrayList;
import java.util.List;

import edu.scut.yao.pojo.Product;
import edu.scut.yao.pojo.Series;

public class ProductViewModel{


    public ProductViewModel() {
    }

    public List<Product> getProducts(){
        List<Product> products = new ArrayList<>();
        for (int i=0;i <100;i++) {
            Product new_product = new Product();
            new_product.setDescription("这是个样例");
            new_product.setName("样例"+ i);
            new_product.setPrice((float) (Math.random()*100+i));
            new_product.setState("未上架");
            Series series = new Series();
            series.setName("系列"+i);
            new_product.setSeries(series);
            products.add(new_product);
        }
        return products;
    }
}