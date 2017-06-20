package com.fudan.ooad.service;

import com.fudan.ooad.Exception.ItemExistException;
import com.fudan.ooad.entity.CheckItem;

import java.util.Set;

/**
 * Created by Jindiwei on 2017/6/19.
 */
public interface ICheckItemService {
    void addCheckItem(CheckItem checkItem) throws ItemExistException;
    void modifyCheckItem(CheckItem checkItem) throws ItemExistException;
    void deleteCheckItem(CheckItem checkItem);
    Set<CheckItem> searchCheckItem(String keyword);
}
