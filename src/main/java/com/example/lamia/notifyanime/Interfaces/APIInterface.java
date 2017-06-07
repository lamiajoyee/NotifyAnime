package com.example.lamia.notifyanime.Interfaces;

import com.example.lamia.notifyanime.Models.AuthModel;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by Lamia on 6/7/2017.
 */

public interface APIInterface {

    @POST("/api/auth/access_token")
    Call<AuthModel> doGetAuthenticated(@Query("grant_type") String grant_type, @Query("client_id") String client_id, @Query("client_secret") String client_secret);

    /*@POST("/api/users")
    Call<User> createUser(@Body User user);

    @GET("/api/users?")
    Call<UserList> doGetUserList(@Query("page") String page);

    @FormUrlEncoded
    @POST("/api/users?")
    Call<UserList> doCreateUserWithField(@Field("name") String name, @Field("job") String job);*/
}
