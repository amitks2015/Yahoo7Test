package com.test.yahoo7test.ui;

import com.test.yahoo7test.model.News;

import java.util.List;

/**
 * Created by amitsingh on 10/31/17.
 */

public interface MainView {
    void onNewsRetrieved(List<News> news);
    void onError(String error);
    void onLoadMore();
}
