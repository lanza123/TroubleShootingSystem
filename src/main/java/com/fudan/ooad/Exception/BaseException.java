package com.fudan.ooad.Exception;

/**
 * Created by Jindiwei on 2017/6/20.
 */
public abstract class BaseException extends RuntimeException{
//    Exception e = new Exception();
    String serviceSource;
    String message;


//    public abstract String getMessage();
//
//    public abstract String ServiceSource();
//
//    public abstract String getResume();
    @Override
    public abstract void printStackTrace();

}
