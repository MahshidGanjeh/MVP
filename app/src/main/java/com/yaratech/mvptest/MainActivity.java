package com.yaratech.mvptest;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.yaratech.mvptest.R;
import com.yaratech.mvptest.userlist.UserListContract;
import com.yaratech.mvptest.userlist.UserListFragment;
import com.yaratech.mvptest.userpost.UserPostFragment;

public class MainActivity extends AppCompatActivity implements UserListContract.goToPost {

    android.support.v4.app.FragmentManager manager = getSupportFragmentManager();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        manager.beginTransaction().addToBackStack("a")
                .replace(R.id.fragment_container, new UserListFragment()).commit();

    }

    @Override
    public void goToPost(int id) {
        manager.beginTransaction().replace(R.id.fragment_container, UserPostFragment.newInstance(id)).commit();
    }
}


