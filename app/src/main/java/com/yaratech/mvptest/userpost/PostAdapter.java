package com.yaratech.mvptest.userpost;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.yaratech.mvptest.R;
import com.yaratech.mvptest.data.model.Post;

import java.util.List;

public class PostAdapter extends RecyclerView.Adapter<PostViewHolder> {

    private List<Post> mPostList;

    public PostAdapter(List<Post> dataList) {
        mPostList = dataList;
    }

    @NonNull
    @Override
    public PostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View result = LayoutInflater.from(parent.getContext()).inflate(R.layout.post_item, parent, false);
        PostViewHolder viewHolder = new PostViewHolder(result);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull PostViewHolder holder, final int position) {
        holder.onBind(mPostList.get(position));
    }

    @Override
    public int getItemCount() {
        return mPostList.size();
    }

}


