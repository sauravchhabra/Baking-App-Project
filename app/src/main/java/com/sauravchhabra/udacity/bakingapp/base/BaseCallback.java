package com.sauravchhabra.udacity.bakingapp.base;

/**
 * Simple interface to define the global methods which other classes will have to implement
 * according to their requirement
 */
public interface BaseCallback {

    void onNetworkConnectionError();

    void onServerError();
}
