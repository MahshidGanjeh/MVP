package com.yaratech.mvptest.userlist;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.yaratech.mvptest.R;

public class MainActivity extends  AppCompatActivity {

    android.support.v4.app.FragmentManager manager = getSupportFragmentManager();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        manager.beginTransaction().replace(R.id.fragment_container, new UserListFragment()).commit();

    }
}
