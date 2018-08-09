package com.yaratech.mvptest.userpost;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.yaratech.mvptest.R;
import com.yaratech.mvptest.data.model.Post;

public class PostViewHolder extends RecyclerView.ViewHolder {

    private TextView title;
    private TextView body;

    public PostViewHolder(View itemView) {
        super(itemView);
        title = itemView.findViewById(R.id.title);
        body = itemView.findViewById(R.id.body);
    }

    public void onBind(Post post) {
        title.setText("Title is : \n" + post.getTitle());
        body.setText("Body is : \n " + post.getBody());
    }
}
