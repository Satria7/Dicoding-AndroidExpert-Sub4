package com.putrasamawa.dicodingmade1.service;

import com.putrasamawa.dicodingmade1.model.ItemMovie;
import com.putrasamawa.dicodingmade1.model.ItemTV;
import com.putrasamawa.dicodingmade1.model.WrapperMovie;
import com.putrasamawa.dicodingmade1.model.WrapperTV;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

//* Satria Junanda *//

public interface RestApiService {

    @GET("discover/movie")
    Call<WrapperMovie> getPopularMovie(@Query("api_key") String api, @Query("language") String language);


    @GET("discover/tv")
    Call<WrapperTV> getPopularTV(@Query("api_key") String api, @Query("language") String language);

    @GET("movie/{id}")
    Call<ItemMovie> getMovieById(@Path("id") String id, @Query("api_key") String apiKey);

    @GET("tv/{id}")
    Call<ItemTV> getTVById(@Path("id") String id, @Query("api_key") String apiKey);
}

//* Satria Junanda *//