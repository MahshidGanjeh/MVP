package com.yaratech.mvptest.userpost;


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
import com.yaratech.mvptest.data.model.Post;
import com.yaratech.mvptest.userlist.UserListPresenter;

import java.util.List;

public class UserPostFragment extends Fragment
        implements UserPostContract.View {

    private UserPostContract.Presenter mPresenter;
    private RecyclerView mRecyclerView;
    private static int mId;

    public UserPostFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_user_post, container, false);
    }

    public static UserPostFragment newInstance(int id) {

        Bundle args = new Bundle();
        args.putInt("userId", id);
        mId = id;
        UserPostFragment fragment = new UserPostFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mPresenter = new UserPostPresenter(this);
        mRecyclerView = view.findViewById(R.id.user_post_recycler);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));

        mPresenter.loadPost(mId);
    }

    @Override
    public void showPost(List<Post> list) {
        mRecyclerView.setAdapter(new PostAdapter(list));
    }

}


