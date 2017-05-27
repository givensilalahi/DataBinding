package com.example.giventrisjeremia.databinding.presenter;

import android.util.Log;

import com.example.giventrisjeremia.databinding.interactor.CoreInteractor;
import com.example.giventrisjeremia.databinding.interactor.QuotesContract;
import com.example.giventrisjeremia.databinding.model.QuotesEntity;
import com.example.giventrisjeremia.databinding.service.CoreInteractorImpl;

import java.util.ArrayList;
import java.util.List;

import rx.Scheduler;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Giventris Jeremia on 21/05/2017.
 */

public class MainPresenter implements QuotesContract.Presenter {

    private static final String TAG = "Main Presenter";

    private CoreInteractorImpl mInteractor;
    private QuotesContract.View mView;
    private List<QuotesEntity> mQuotes;

    public MainPresenter(CoreInteractorImpl interactor){
        mInteractor = interactor;
        mQuotes = new ArrayList<>();
    }

    public void bind(QuotesContract.View view) {
        mView = view;
    }

    @Override
    public void unbind() {
        mView = null;
    }

    @Override
    public void getQuotesHistory() {
        mInteractor.getQuotesHistoryTransaction()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<List<QuotesEntity>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e(TAG, e.getMessage(),e);
                        if (mView == null){
                            return;
                        }
                        mView.hideProgress();
                    }

                    @Override
                    public void onNext(List<QuotesEntity> quotesEntities) {
                        mQuotes.addAll(quotesEntities);
                        if(mView != null){
                            mView.hideProgress();
                        }
                        mView.updateQuotes(quotesEntities);
                    }
                });
    }
}
