package com.yaratech.mvptest.userlist;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.yaratech.mvptest.R;
import com.yaratech.mvptest.data.model.User;

import java.util.List;

public class UserListFragment extends Fragment
        implements UserListContract.View {

    private UserListContract.Presenter mPresenter;
    private RecyclerView mRecyclerView;

    public UserListFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_user_list, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mPresenter = new UserListPresenter(this);
        mRecyclerView = view.findViewById(R.id.user_list_recycler);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        mPresenter.loadData();
    }
    @Override
    public void showUsers() {
        UserAdapter adapter = new UserAdapter(mPresenter.loadData());
        mRecyclerView.setAdapter(adapter);
    }
}
