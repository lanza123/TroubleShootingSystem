package com.fudan.ooad.Exception;

/**
 * Created by Jindiwei on 2017/6/20.
 */
public class ItemNotExistException extends BaseException {

    String serviceSource;
    String message;
    public ItemNotExistException(){

    }
    public ItemNotExistException(String serviceSource){
        message = "Can not add the CheckItem, CheckItem is existed";
        this.serviceSource = serviceSource;
    }

    @Override
    public void printStackTrace() {
        System.out.println("Wrong: "+ message +"; Service Source:" + serviceSource);
    }
}
