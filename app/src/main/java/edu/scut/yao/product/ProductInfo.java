package edu.scut.yao.product;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

import edu.scut.yao.R;
import edu.scut.yao.pojo.Product;
import edu.scut.yao.utils.Utils;

public class ProductInfo extends AppCompatActivity {
    private boolean btnState = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.product_info);
        initView();
    }

    private void initView(){
        Product product = (Product) getIntent().getSerializableExtra("product");
        ImageView productImage = findViewById(R.id.product_info_image);
        assert product != null;
        productImage.setImageResource(product.getImage());
        EditText productName = findViewById(R.id.product_info_name);
        productName.setText(product.getName());
        EditText productIntro = findViewById(R.id.product_info_des);
        productIntro.setText(product.getDescription());
    }

    public void clickButton(View view){
        Button button = findViewById(R.id.product_info_bnt);
        List<View> allViewsInActivity = Utils.getAllChildViews(this.getWindow().getDecorView());
        List<EditText> editTexts = getAllEditTexts(allViewsInActivity);
        if(btnState){ // 当前状态为edit
            for (EditText editText: editTexts) {
                editText.setEnabled(true);
            }
            button.setText(R.string.product_btn2);
            btnState = false;
        }else{// 当前状态为save
            for (EditText editText: editTexts) {
                editText.setEnabled(false);
            }
            button.setText(R.string.product_btn1);
            saveChange(view);
            btnState = true;
        }
    }

    private List<EditText> getAllEditTexts(List<View> views){
        List<EditText> editTexts = new ArrayList<>();
        for (View view: views) {
            if(view instanceof EditText){
                editTexts.add((EditText) view);
            }
        }
        return editTexts;
    }

    private void saveChange(View view){
        new AlertDialog.Builder(this)
                .setTitle(view.getContext().getString(R.string.login_tip))//设置对话框标
                .setMessage("save successful!")//设置显示的内容
                .show();
    }
}