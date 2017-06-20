package com.fudan.ooad.Exception;

/**
 * Created by Jindiwei on 2017/6/20.
 */
public class TemplateNotExistException extends BaseException{

    String serviceSource;
    String message;
    public TemplateNotExistException(){

    }
    public TemplateNotExistException(String serviceSource){
        message = "Can not add the template, template is existed";
        this.serviceSource = serviceSource;
    }

    @Override
    public void printStackTrace() {
        System.out.println("Wrong: "+ message +"; Service Source:" + serviceSource);
    }
}
