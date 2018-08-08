package com.yaratech.mvptest.userlist;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import com.yaratech.mvptest.data.model.User;

import com.yaratech.mvptest.R;

class MyViewHolder extends RecyclerView.ViewHolder {

    private TextView name;
    private TextView email;

    public MyViewHolder(final View itemView) {
        super(itemView);
        name = itemView.findViewById(R.id.name);
        email = itemView.findViewById(R.id.email);
    }

    public void onBind(User user) {
        name.setText(user.getName());
        email.setText(user.getEmail());
    }
}