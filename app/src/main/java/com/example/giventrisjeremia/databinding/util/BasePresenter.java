package com.example.giventrisjeremia.databinding.util;

/**
 * Created by Giventris Jeremia on 21/05/2017.
 */

public interface BasePresenter<V> {

    void bind(V view);
    void unbind();
}
