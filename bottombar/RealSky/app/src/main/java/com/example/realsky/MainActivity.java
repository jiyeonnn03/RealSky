package com.example.realsky;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.realsky.ui.add.AddFragment;
import com.example.realsky.ui.commu.CommuFragment;
import com.example.realsky.ui.home.HomeFragment;
import com.example.realsky.ui.mypage.MypageFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {


    private FragmentManager fragmentManager = getSupportFragmentManager();
    private HomeFragment fragmentHome = new HomeFragment();
    private CommuFragment fragmentCommu = new CommuFragment();
    private MypageFragment fragmentMypage = new MypageFragment();
    private AddFragment fragmentAdd = new AddFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_login);
        setContentView(R.layout.activity_bottom_menu);

        FragmentTransaction transaction = fragmentManager.beginTransaction();
//        transaction.replace(R.id.frameLayout, fragmentHome).commitAllowingStateLoss();



        BottomNavigationView bottomNavigationView = findViewById(R.id.navigationView);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                // handle desired action here
                // One possibility of action is to replace the contents above the nav bar
                // return true if you want the item to be displayed as the selected item
                return true;
            }
        });

        bottomNavigationView.setOnNavigationItemSelectedListener(new ItemSelectedListener());
    }

    class ItemSelectedListener implements BottomNavigationView.OnNavigationItemSelectedListener{
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
            FragmentTransaction transaction = fragmentManager.beginTransaction();

            switch(menuItem.getItemId())
            {
                case R.id.homeItem:
                    transaction.replace(R.id.frameLayout, fragmentHome).commitAllowingStateLoss();
                    return true;
                case R.id.commuItem:
                    transaction.replace(R.id.frameLayout, fragmentCommu).commitAllowingStateLoss();
                    return true;
                case R.id.mypageItem:
                    transaction.replace(R.id.frameLayout, fragmentMypage).commitAllowingStateLoss();
                    return true;
                case R.id.addItem:
                    transaction.replace(R.id.frameLayout, fragmentAdd).commitAllowingStateLoss();
                    return true;
            }
            return false;
        }
    }
}
