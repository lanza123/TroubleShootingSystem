package com.fudan.ooad.Exception;

/**
 * Created by Jindiwei on 2017/6/20.
 */
public class TemplateExistException extends BaseException{

    @Override
    public String getMessage() {
        return "Template already exist.";
    }

    @Override
    public String ServiceSource() {
        return null;
    }

    @Override
    public String getResume() {
        return null;
    }
}
