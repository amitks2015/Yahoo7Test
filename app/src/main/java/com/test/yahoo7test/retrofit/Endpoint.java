package com.test.yahoo7test.retrofit;

import com.test.yahoo7test.model.News;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by amitsingh on 10/31/17.
 */

public interface Endpoint {

    @GET("news")
    Observable<List<News>> getNews(@Query("index") int index);
}
