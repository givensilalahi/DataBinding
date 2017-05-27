package com.example.giventrisjeremia.databinding.interactor;

import com.example.giventrisjeremia.databinding.model.QuotesEntity;
import com.example.giventrisjeremia.databinding.util.BasePresenter;
import com.example.giventrisjeremia.databinding.util.BaseView;

import java.util.List;

/**
 * Created by Giventris Jeremia on 21/05/2017.
 */

public interface QuotesContract {

    interface View extends BaseView<Presenter>{

        void updateQuotes(List<QuotesEntity> quotesEntities);

        void showProgress();

        void hideProgress();

    }

    interface Presenter extends BasePresenter<View>{
        void getQuotesHistory();
    }
}
