package edu.scut.yao;

import android.os.Bundle;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

public class HomePage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_page);
        BottomNavigationView navView = findViewById(R.id.home_page_nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.home_page_nav_home, R.id.home_page_nav_user, R.id.home_page_nav_not)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(navView, navController);
    }

    private static final int TIME_EXIT=2000;
    private long mBackPressed=0;

    @Override
    public void onBackPressed(){
        if(mBackPressed+TIME_EXIT>System.currentTimeMillis()){
            super.onBackPressed();
        }else{
            Toast.makeText(this,"再点击一次返回退出程序",Toast.LENGTH_SHORT).show();
            mBackPressed=System.currentTimeMillis();
        }
    }

}