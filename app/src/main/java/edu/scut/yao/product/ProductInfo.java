package edu.scut.yao.product;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;

import edu.scut.yao.R;
import edu.scut.yao.pojo.Product;

public class ProductInfo extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.product_info);
    }

    private void initView(){
        Product product = (Product) getIntent().getSerializableExtra("product");
        ImageView productImage = findViewById(R.id.product_info_image);
        assert product != null;
        productImage.setImageResource(product.getImage());
        EditText productName = findViewById(R.id.product_info_name);
        EditText productIntro = findViewById(R.id.product_info_des);
    }
}