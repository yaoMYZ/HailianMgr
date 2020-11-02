package edu.scut.yao.product;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

import edu.scut.yao.R;
import edu.scut.yao.adapter.ProductAdapter;

public class Product extends AppCompatActivity {
    private ProductViewModel productViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.product);
        productViewModel = new ProductViewModel();
        initListView();
    }

    private void initListView(){
        // 先拿到数据并放在适配器上
        final List<edu.scut.yao.pojo.Product>products = productViewModel.getProducts(); //初始化水果数据
        ProductAdapter adapter=new ProductAdapter(Product.this,R.layout.product_list,products);

        // 将适配器上的数据传递给listView
        ListView listView=findViewById(R.id.product_list);
        listView.setAdapter(adapter);

        // 为ListView注册一个监听器，当用户点击了ListView中的任何一个子项时，就会回调onItemClick()方法
        // 在这个方法中可以通过position参数判断出用户点击的是那一个子项
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                edu.scut.yao.pojo.Product product=products.get(position);
                Toast.makeText(Product.this,product.getName(),Toast.LENGTH_SHORT).show();
            }
        });
    }
}