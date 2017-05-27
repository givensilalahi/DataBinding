package com.example.giventrisjeremia.databinding.service;

import android.content.Context;

import com.example.giventrisjeremia.databinding.interactor.CoreInteractor;
import com.example.giventrisjeremia.databinding.model.QuotesEntity;

import java.util.List;

import rx.Observable;

/**
 * Created by Giventris Jeremia on 21/05/2017.
 */

public class CoreInteractorImpl implements CoreInteractor {

    private CoreApiService mCoreApi;
    private Context mContext;

    public CoreInteractorImpl(Context context){
        mCoreApi = CoreApiServiceBuilder.provideCoreApiService();
        mContext  = context;
    }

    @Override
    public Observable<List<QuotesEntity>> getQuotesHistoryTransaction() {
        return mCoreApi.getQuotes();
    }
}
