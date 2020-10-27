package edu.scut.yao.login;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import edu.scut.yao.home_page.HomePage;
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
            Intent intent = new Intent(this,HomePage.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        }else{
            new AlertDialog.Builder(this)
                    .setTitle(view.getContext().getString(R.string.login_tip))//设置对话框标
                    .setMessage(view.getContext().getString(R.string.login_login_error))//设置显示的内容
                    .show();
        }

    }

    private boolean verify(){
        return true;
//        EditText ic_phone = findViewById(R.id.login_phone);
//        String account = ic_phone.getText().toString();
//        EditText ic_password = findViewById(R.id.login_password);
//        String psw = ic_password.getText().toString();
//        if(account.equals("12345") && psw.equals("12345")){
//            SharedPreferences sharedPreferences = getSharedPreferences("user",MODE_PRIVATE);
//            SharedPreferences.Editor editor = sharedPreferences.edit();
//            editor.putString("ic_phone",account);
//            editor.putString("pssword",psw);
//            editor.apply();
//            return true;
//        }
//        return false;
    }
}