package com.yaratech.mvptest.data.remote;

import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;

public interface GetDataService {
    @GET("/users")
    Call<List<com.yaratech.mvptest.data.model.User>> getUsers();

    // @GET("/posts" )
    //Call<List<Post>> getPosts(@Query("userId") int userId);
}