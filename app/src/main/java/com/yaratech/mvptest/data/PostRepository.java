package com.yaratech.mvptest.data;

import com.yaratech.mvptest.data.model.Post;
import com.yaratech.mvptest.data.remote.GetDataService;
import com.yaratech.mvptest.data.remote.RetrofitClient;
import com.yaratech.mvptest.userpost.UserPostContract;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PostRepository {

    public PostRepository() {
    }

    public void fetchPosts(int userId , final UserPostContract.ApiResult callback){
        RetrofitClient.getClient().create(GetDataService.class).getPosts(userId).enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
                callback.onSuccess(response.body());
            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {

            }
        });
    }


}
