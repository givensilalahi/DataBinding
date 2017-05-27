 package com.example.giventrisjeremia.databinding.util;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.giventrisjeremia.databinding.R;
import com.example.giventrisjeremia.databinding.adapter.AdapterMain;
import com.example.giventrisjeremia.databinding.databinding.ActivityMainBinding;
import com.example.giventrisjeremia.databinding.interactor.QuotesContract;
import com.example.giventrisjeremia.databinding.model.QuotesEntity;
import com.example.giventrisjeremia.databinding.presenter.MainPresenter;
import com.example.giventrisjeremia.databinding.service.CoreInteractorImpl;

import java.util.List;

public class MainActivity extends AppCompatActivity implements QuotesContract.View{

    private ActivityMainBinding mBinding;

    private AdapterMain mAdapterMain;

    private RecyclerView mRecyclerView;

    private List<QuotesEntity> mQuotesEntity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        initRecycleView();
        QuotesContract.Presenter mPresenter = initPresenter();
        mPresenter.bind(this);

        showProgress();
        mPresenter.getQuotesHistory();

    }

    private void initRecycleView() {

        mRecyclerView = mBinding.listitem;
        mRecyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(layoutManager);

    }

    @Override
    public QuotesContract.Presenter initPresenter() {
        return new MainPresenter(new CoreInteractorImpl(getApplicationContext()));
    }

    @Override
    public void updateQuotes(List<QuotesEntity> quotesEntities) {

        mQuotesEntity = quotesEntities;
        if (mAdapterMain == null){
            mAdapterMain = new AdapterMain(this, quotesEntities);
        }
        if (mRecyclerView.getAdapter() == null){
            mRecyclerView.setAdapter(mAdapterMain);
        }
        else {
            //belum handle
            Toast.makeText(this, "+ not added", Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }
}
