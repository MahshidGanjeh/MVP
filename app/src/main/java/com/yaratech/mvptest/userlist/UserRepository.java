package com.yaratech.mvptest.userlist;

import android.content.Context;
import android.util.Log;

import com.yaratech.mvptest.data.model.User;
import com.yaratech.mvptest.data.remote.GetDataService;
import com.yaratech.mvptest.data.remote.RetrofitClient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.support.constraint.Constraints.TAG;

public class UserRepository {

    List<User> mUsersList ;
    private static final String TAG = "UserRepository";

    public UserRepository() {
    }

    public List<User> fetchUsers(final ApiResult callback) {
        RetrofitClient.getClient().create(GetDataService.class).getUsers().enqueue(new Callback<List<User>>() {
            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {
                Log.i(TAG, "onFailure: " + t.getMessage());
                callback.onFail();
            }

            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                if (response.isSuccessful()) {
                    mUsersList = response.body();
                    callback.onSuccess(mUsersList);
                    Log.i(TAG, "onResponse: " + mUsersList.size());
                } else {
                    Log.i(TAG, "onResponse: not");
                }
            }
        });
        return mUsersList;
    }

    public interface ApiResult {
        void onSuccess(List<User> list);

        void onFail();
    }
}
