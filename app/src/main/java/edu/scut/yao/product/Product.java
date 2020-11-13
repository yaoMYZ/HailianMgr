package edu.scut.yao.product;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import java.util.List;

import edu.scut.yao.R;
import edu.scut.yao.adapter.ProductAdapter;

public class Product extends AppCompatActivity {
    private ProductViewModel productViewModel;
    private boolean showFilter = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.product);
        productViewModel = new ProductViewModel();
        initListView();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.product_top_menu, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.product_search:
                Toast.makeText(this, "点击了 search ", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.product_filter:
                DrawerLayout drawerLayout = findViewById(R.id.product_drawerLayout);
                if(showFilter){
                    drawerLayout.openDrawer(GravityCompat.END);
                    showFilter = false;
                }else{
                    drawerLayout.closeDrawer(GravityCompat.END);
                    showFilter = true;
                }
                return true;
            default:    // 如果用户的行为没有被执行，则会调用父类的方法去处理，建议保留。
                return super.onOptionsItemSelected(item);
        }
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
                Intent intent = new Intent(Product.this, ProductInfo.class);
                intent.putExtra("product", product);
                startActivity(intent);
//                Toast.makeText(Product.this,product.getName(),Toast.LENGTH_SHORT).show();
            }
        });
    }

}