package com.sauravchhabra.udacity.bakingapp.utils;

import retrofit2.HttpException;


/**
 * A simple class to check if the web address is invalid and throw the exception
 */
public class ServerErrorUtils {

    public final static String SERVER_ERROR = "Unable to resolve host : No address associated with hostname";

    public static boolean isHttp404(Throwable t) {
        return t instanceof HttpException && ((HttpException) t).code() == 404;
    }
}
