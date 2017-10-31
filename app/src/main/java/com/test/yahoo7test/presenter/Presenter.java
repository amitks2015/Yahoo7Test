package com.test.yahoo7test.presenter;

import android.support.annotation.NonNull;
import android.util.Log;

import com.test.yahoo7test.model.News;
import com.test.yahoo7test.retrofit.Endpoint;
import com.test.yahoo7test.retrofit.RetrofitHelper;
import com.test.yahoo7test.ui.MainView;


import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by amitsingh on 10/31/17.
 */

public class Presenter {

    private MainView view;
    private Endpoint mEndpoint;

    public Presenter(MainView view) {
        this.view = view;
        mEndpoint = new RetrofitHelper().getEndpoint();
    }

    public void fetchNews(int index) {
        mEndpoint.getNews(index)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(responseHandler, errorHandler);
    }

    public void destroy() {
        //cleanup
    }

    private Consumer<List<News>> responseHandler = new Consumer<List<News>>() {
        @Override
        public void accept(List<News> news) throws Exception {
            //Handle response.
            view.onNewsRetrieved(news);

        }
    };

    private Consumer<Throwable> errorHandler = new Consumer<Throwable>() {
        @Override
        public void accept(@NonNull Throwable throwable) throws Exception {
            view.onError(throwable.getMessage());
        }
    };
}
