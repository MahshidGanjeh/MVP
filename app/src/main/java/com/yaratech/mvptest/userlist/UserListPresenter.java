package com.yaratech.mvptest.userlist;

import android.util.Log;

import com.yaratech.mvptest.data.UserRepository;
import com.yaratech.mvptest.data.model.User;

import java.util.List;

import static android.support.constraint.Constraints.TAG;


public class UserListPresenter implements UserListContract.Presenter {

    private UserListContract.View mView;
    private UserRepository mUserRepository = new UserRepository();

    public UserListPresenter(UserListContract.View mView) {
        this.mView = mView;
    }

    @Override
    public void loadData() {
        mUserRepository.fetchUsers(new UserRepository.ApiResult() {
            @Override
            public void onSuccess(List<User> list) {
                Log.i(TAG, "onResponse: " +list.get(0).getName());
                mView.showUsers(list);
            }
            @Override
            public void onFail() {
            }
        });
    }
}
