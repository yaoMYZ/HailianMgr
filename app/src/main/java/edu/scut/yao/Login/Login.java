package edu.scut.yao.Login;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import edu.scut.yao.HomePage;
import edu.scut.yao.R;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
    }

    public void signUp(View view){
        Intent intent = new Intent(this,Signup.class);
        startActivity(intent);
    }

    public void toHomePage(View view){
        if(verify()){
            Intent intent = new Intent(this, HomePage.class);
            startActivity(intent);
        }else{
            new AlertDialog.Builder(this)
                    .setTitle(view.getContext().getString(R.string.login_tip))//设置对话框标
                    .setMessage(view.getContext().getString(R.string.login_login_error))//设置显示的内容
                    .show();
        }

    }

    private boolean verify(){
        EditText phone = findViewById(R.id.login_phone);
        String account = phone.getText().toString();
        EditText password = findViewById(R.id.login_password);
        String psw = password.getText().toString();
        if(account.equals("12345") && psw.equals("12345")){
            SharedPreferences sharedPreferences = getSharedPreferences("user",MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString("phone",account);
            editor.putString("pssword",psw);
            editor.apply();
            return true;
        }
        return false;
    }
}