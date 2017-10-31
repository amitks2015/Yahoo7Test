package com.test.yahoo7test.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.test.yahoo7test.R;
import com.test.yahoo7test.model.News;
import com.test.yahoo7test.presenter.Presenter;

import java.util.List;

public class MainActivity extends AppCompatActivity implements MainView {

    private Presenter mPresenter;
    private RecyclerView recyclerView;
    private List<News> newsList;
    private MyAdapter mAdapter;
    private int page = 0;
    List<News> mData;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recycler_view);
        mPresenter = new Presenter(this);
        mPresenter.fetchNews(page);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        mAdapter = new MyAdapter(this, recyclerView, newsList);
        recyclerView.setAdapter(mAdapter);
    }

    @Override
    protected void onDestroy() {
        mPresenter.destroy();
        super.onDestroy();
    }

    @Override
    public void onNewsRetrieved(List<News> newsList) {
        if(mData == null) {
            mData = newsList;
            mAdapter.setData(newsList);
        } else {
            //Add new data to the list
            mData.remove(mData.size()-1);
            mAdapter.notifyItemRemoved(mData.size());
            mData.addAll(mData.size(), newsList);
        }
        mAdapter.notifyDataSetChanged();
        mAdapter.setLoaded();
    }

    @Override
    public void onError(String error) {
        Toast.makeText(this, R.string.data_exausted, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onLoadMore() {
        mData.add(null);
        mAdapter.notifyItemInserted(mData.size()-1);

        page++;

        mPresenter.fetchNews(page);
    }
}
