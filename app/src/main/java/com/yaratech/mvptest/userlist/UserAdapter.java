package com.yaratech.mvptest.userlist;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.yaratech.mvptest.R;
import com.yaratech.mvptest.data.model.User;

import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<MyViewHolder> {
    private List<User> mUserList;

    public UserAdapter(List<User> mUserList) {
        this.mUserList = mUserList;
    }

    public UserAdapter() {
    }

// public UserAdapter(onUserClicked listener) {
       // mListener = listener;
    //}

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View result = LayoutInflater.from(parent.getContext()).inflate(R.layout.user_item, parent
                , false);
        MyViewHolder viewHolder = new MyViewHolder(result);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.onBind(mUserList.get(position));
    }

    @Override
    public int getItemCount() {
        return mUserList.size();
    }
}

