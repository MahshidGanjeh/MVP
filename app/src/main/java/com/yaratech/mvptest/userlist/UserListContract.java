package com.yaratech.mvptest.userlist;

import com.yaratech.mvptest.data.model.User;

import java.util.List;

public interface UserListContract {

    interface View {
        void showUsers(List<User> list);

    }

    interface Presenter {
        void loadData();
    }

    interface goToPost {
        void goToPost(int id);
    }
}
