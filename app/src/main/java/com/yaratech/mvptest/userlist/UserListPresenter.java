package com.yaratech.mvptest.userlist;

import android.content.Context;

import com.yaratech.mvptest.data.model.User;

import java.util.List;


public class UserListPresenter implements UserListContract.Presenter {

    private UserListContract.View mView;
    private List<User> users;

    public UserListPresenter(UserListContract.View mView) {
        this.mView = mView;
    }

    @Override
    public List<User> loadData() {
        UserRepository mUserRepository = new UserRepository();
        users = mUserRepository.fetchUsers(new UserRepository.ApiResult() {
            @Override
            public void onSuccess(List<User> list) {
                mView.showUsers();
            }
            @Override
            public void onFail() {
            }
        });
        return users;
    }
}
