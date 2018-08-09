package com.yaratech.mvptest.userpost;

import com.yaratech.mvptest.data.PostRepository;
import com.yaratech.mvptest.data.model.Post;

import java.util.List;

public class UserPostPresenter implements UserPostContract.Presenter
{

    private PostRepository mRepository;
    private UserPostContract.View mView;

    public UserPostPresenter(UserPostContract.View mView) {
        this.mView = mView;
    }


    @Override
    public void loadPost(int id) {
        mRepository = new PostRepository();
        mRepository.fetchPosts(id, new UserPostContract.ApiResult() {
            @Override
            public void onSuccess(List<Post> list) {
                mView.showPost(list);
            }
            @Override
            public void onFail() {
            }
        });
    }
}
