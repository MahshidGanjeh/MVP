package com.yaratech.mvptest.data;

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

    private static final String TAG = "UserRepository";

    public UserRepository() {
    }

    public void fetchUsers(final ApiResult callback) {
        RetrofitClient.getClient().create(GetDataService.class).getUsers().enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                if (response.isSuccessful()) {
                    Log.i(TAG, "onResponse: " +response.body().get(0).getName());
                    callback.onSuccess(response.body());

                } else {
                    Log.i(TAG, "onResponse: not");
                }
            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {
                Log.i(TAG, "onFailure: " + t.getMessage());
                callback.onFail();
            }
        });
    }

    public interface ApiResult {
        void onSuccess(List<User> list);

        void onFail();
    }
}
