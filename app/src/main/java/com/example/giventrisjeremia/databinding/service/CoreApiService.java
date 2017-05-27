package com.example.giventrisjeremia.databinding.service;

import com.example.giventrisjeremia.databinding.model.QuotesEntity;

import java.util.List;
import java.util.Observable;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Giventris Jeremia on 21/05/2017.
 */

public interface CoreApiService {
    String END_POINT = "questions";

    @GET(END_POINT)
    rx.Observable<List<QuotesEntity>> getQuotes();
}
