package com.smallwei.day2demo;
import com.squareup.picasso.Downloader;

import java.util.List;

import retrofit.Call;
import retrofit.http.GET;
import retrofit.http.Path;
import retrofit.http.Query;

public interface QsbkInterface {
    @GET("article/list/{type}")
    Call<List<ListItem>> getList(@Path("type") String type,@Query("page") int page);
    //Call<Response> getList(@Path("type") String type, @Query("page") int page);
}
