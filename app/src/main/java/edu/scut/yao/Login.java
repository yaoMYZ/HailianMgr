package edu.scut.yao;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

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
            Intent intent = new Intent(this,HomePage.class);
            startActivity(intent);
        }else{
            new AlertDialog.Builder(this)
                    .setTitle(view.getContext().getString(R.string.login_tip))//设置对话框标
                    .setMessage(view.getContext().getString(R.string.login_login_error))//设置显示的内容
                    .show();
        }

    }

    private boolean verify(){
        EditText editTextAccount = findViewById(R.id.login_phone);
        String account = editTextAccount.getText().toString();
        EditText editTextPassword = findViewById(R.id.login_password);
        String password = editTextPassword.getText().toString();
        if(account.equals("root") && password.equals("12345")){
            SharedPreferences sharedPreferences = getSharedPreferences("user",MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString("account",account);
            editor.putString("pssword",password);
            editor.apply();
            return true;
        }
        return false;
    }
}