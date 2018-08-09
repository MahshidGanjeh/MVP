package com.yaratech.mvptest.userpost;

import com.yaratech.mvptest.data.model.Post;
import com.yaratech.mvptest.data.model.User;

import java.util.List;

public interface UserPostContract {

    interface View{
        void showPost(List<Post> list);
    }

    interface Presenter{
        void loadPost(int id);
    }

    interface ApiResult{
        void onSuccess(List<Post> list);
        void onFail();
    }
    interface PostRecyclerViewListener{
        void setOnItemClickListener(int id);
    }
}
