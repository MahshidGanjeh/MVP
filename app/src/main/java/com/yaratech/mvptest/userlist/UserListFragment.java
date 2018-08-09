package com.yaratech.mvptest.userlist;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.yaratech.mvptest.R;
import com.yaratech.mvptest.data.model.User;
import com.yaratech.mvptest.userpost.UserPostContract;

import java.util.List;

public class UserListFragment extends Fragment
        implements UserListContract.View, UserPostContract.PostRecyclerViewListener {

    private UserListContract.Presenter mPresenter;
    private RecyclerView mRecyclerView;
    private UserListContract.goToPost mGoToPost;
    private int mId;

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
    public void onAttach(Context context) {
        super.onAttach(context);
        mGoToPost = (UserListContract.goToPost) context;
    }

    @Override
    public void showUsers(List<User> list) {
        mRecyclerView.setAdapter(new UserAdapter(list, this));
    }


    @Override
    public void setOnItemClickListener(int id) {
        mId = id;
        mGoToPost.goToPost(id);
        Toast.makeText(getContext(), String.valueOf(mId), Toast.LENGTH_SHORT).show();
    }
}
