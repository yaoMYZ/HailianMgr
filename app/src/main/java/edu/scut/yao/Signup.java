package edu.scut.yao;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class Signup extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);

        this.initSpinner();
    }

    private void initSpinner(){
        final String[] pos=this.getPositions();
        Spinner spinner = findViewById(R.id.signup_position_spinner);
        // 建立Adapter并且绑定数据源
        ArrayAdapter<String> adapter=new ArrayAdapter<>(this,R.layout.spinner_item, pos);
//        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapter.setDropDownViewResource(R.layout.spinner_dropdown_item);
        //绑定 Adapter到控件
        spinner .setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(Signup.this, "你点击的是:"+pos[position], Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Another interface callback
            }
        });
    }

    private String[] getPositions(){
        String []strings = new String[30];
        for (int i=0;i<strings.length;i++){
            strings[i] = "样例".concat(String.valueOf(i));
        }
        return strings;
//        return new String[]{"管理层","采购","生产","财务","仓库","业务","外发"};
    }


}
