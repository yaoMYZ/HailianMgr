package edu.scut.yao.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import com.alibaba.fastjson.JSON;

import edu.scut.yao.R;
import edu.scut.yao.pojo.User;

public class Signup extends AppCompatActivity {
    private int sex = -1;
    private int posIdx = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);

        initSpinner();
        initRadioGroup();
    }

    private void initSpinner(){
        final String[] pos=this.getPositions();
        Spinner spinner = findViewById(R.id.signup_position_spinner);
        // 建立Adapter并且绑定数据源
        ArrayAdapter<String> adapter=new ArrayAdapter<>(this,R.layout.spinner_item, pos);
        adapter.setDropDownViewResource(R.layout.spinner_dropdown_item);
        //绑定 Adapter到控件
        spinner .setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                posIdx = position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Another interface callback
            }
        });
    }

    private void initRadioGroup(){
        RadioGroup radioGroup_orientation = findViewById(R.id.signup_sex_choose);
        radioGroup_orientation.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (group.getCheckedRadioButtonId()) {
                    case R.id.signup_sex_man:
                        sex = 0;
                        break;
                    case R.id.signup_sex_woman:
                        sex = 1;
                        break;
                    default:
                        break;
                }
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

    public void signUp(View view){
        String phone = ((EditText) findViewById(R.id.signup_phone)).getText().toString();
        String password = ((EditText) findViewById(R.id.signup_password)).getText().toString();
        String name = ((EditText) findViewById(R.id.signup_name)).getText().toString();
        User user = new User(phone,password,name,sex,posIdx);
        String userJson = JSON.toJSONString(user);
        Toast.makeText(Signup.this, userJson, Toast.LENGTH_LONG).show();
    }

    public void signIn(View view){
        Intent intent = new Intent(this,Login.class);
        startActivity(intent);
    }

}
