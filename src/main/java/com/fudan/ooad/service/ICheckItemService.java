package com.fudan.ooad.service;

import com.fudan.ooad.entity.CheckItem;
import com.fudan.ooad.exception.BaseException;

import java.util.Set;

/**
 * Created by Jindiwei on 2017/6/19.
 */
public interface ICheckItemService {
    void createCheckItem(CheckItem checkItem) throws BaseException;
    void modifyCheckItem(CheckItem checkItem) throws BaseException;
    void deleteCheckItem(CheckItem checkItem) throws BaseException;
    Set<CheckItem> searchCheckItem(String keyword) throws BaseException;
}
