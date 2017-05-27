package com.example.giventrisjeremia.databinding.interactor;

import com.example.giventrisjeremia.databinding.model.QuotesEntity;

import java.util.List;

import rx.Observable;

/**
 * Created by Giventris Jeremia on 21/05/2017.
 */

public interface CoreInteractor {
    Observable<List<QuotesEntity>> getQuotesHistoryTransaction();
}
