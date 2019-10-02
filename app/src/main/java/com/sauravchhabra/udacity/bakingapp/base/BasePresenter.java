package com.sauravchhabra.udacity.bakingapp.base;


/**
 * Simple interface to define the global methods which other classes will have to implement
 * according to their requirement
 */
public interface BasePresenter<V> {

    void setView(V view);

    void detachView();
}
