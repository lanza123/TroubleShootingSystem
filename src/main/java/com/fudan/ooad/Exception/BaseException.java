package com.fudan.ooad.Exception;

/**
 * Created by Jindiwei on 2017/6/20.
 */
public abstract class BaseException extends Exception{
//    Exception e = new Exception();
    public abstract String getMessage();

    public abstract String ServiceSource();

    public abstract String getResume();

}
