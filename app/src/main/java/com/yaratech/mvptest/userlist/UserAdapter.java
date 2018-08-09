package com.yaratech.mvptest.userlist;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.yaratech.mvptest.R;
import com.yaratech.mvptest.data.model.User;
import com.yaratech.mvptest.userpost.UserPostContract;

import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<MyViewHolder> {

    private List<User> mUserList;
    private UserPostContract.PostRecyclerViewListener mListener;

    public UserAdapter(List<User> l,UserPostContract.PostRecyclerViewListener listener) {
        mUserList = l;
        mListener = listener;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View resultView = LayoutInflater.from(parent.getContext()).inflate(R.layout.user_item, parent
                , false);
        MyViewHolder viewHolder = new MyViewHolder(resultView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
        holder.onBind(mUserList.get(position));

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mListener.setOnItemClickListener(mUserList.get(position).getId());
            }
        });
    }

    @Override
    public int getItemCount() {
        return mUserList.size();
    }

    public void setUsers(List<User> users) {
        mUserList = users;
        notifyDataSetChanged();
        Log.i("adapter", "setUsers: called ================");
    }
}

