package com.test.yahoo7test.retrofit;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by amitsingh on 10/31/17.
 */

public class RetrofitHelper {

    private Retrofit createRetrofit() {
        return new Retrofit.Builder()
                .baseUrl("https://aboutdoor.info/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

    public Endpoint getEndpoint() {
        final Retrofit retrofit = createRetrofit();
        return retrofit.create(Endpoint.class);
    }
}
