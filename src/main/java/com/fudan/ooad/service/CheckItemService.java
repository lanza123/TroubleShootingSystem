package com.fudan.ooad.service;

import com.fudan.ooad.entity.CheckItem;
import com.fudan.ooad.exception.BaseException;
import com.fudan.ooad.exception.InvalidPropertyException;
import com.fudan.ooad.exception.NullEntityException;
import com.fudan.ooad.exception.SystemException;
import com.fudan.ooad.repository.CheckItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * Created by Jindiwei on 2017/6/20.
 */
@Service
public class CheckItemService implements ICheckItemService {

    @Autowired
    private CheckItemRepository checkItemRepository;

    private final String SERVICE_NAME = "CheckItemService";

    @Override
    public void createCheckItem(CheckItem checkItem) throws BaseException {
        //添加： 属性：title content
        // 1、title是否已存在
        // 2、content是否相同
        if(!CheckItemExist(checkItem)){
            try {
                checkItemRepository.save(checkItem);
            }catch(Exception e){
                throw new SystemException(SERVICE_NAME, e.getMessage());
            }
        }
        else{
            throw new InvalidPropertyException(
                    SERVICE_NAME,
                    "The checkItem is already in the database."
            );
        }
    }

    @Override
    public void modifyCheckItem(CheckItem checkItem) throws BaseException {
        //检查是否有ID
        if(!checkItemRepository.exists(checkItem.getId())){
            throw new NullEntityException(
                    SERVICE_NAME,
                    "checkItem does not exist in database, Try to use checkItemService.createCheckItem instead"
            );
        }
        else{
            try {
                checkItemRepository.save(checkItem);
            }catch(Exception e){
                throw new SystemException(SERVICE_NAME, e.getMessage());
            }
        }
    }

    @Override
    public void deleteCheckItem(CheckItem checkItem) throws BaseException{
        if(!checkItemRepository.exists(checkItem.getId())){
            throw new NullEntityException(
                    SERVICE_NAME,
                    "checkItem does not exist in database, Try to use checkItemService.createCheckItem instead"
            );
        }
        else {
            try {
                checkItemRepository.delete(checkItem.getId());
            }catch(Exception e){
                throw new SystemException(SERVICE_NAME, e.getMessage());
            }
        }
    }

    @Override
    public Set<CheckItem> searchCheckItem(String keyword) throws BaseException{
        Set<CheckItem> checkItems;
        try {
            checkItems = checkItemRepository.findByTitleContainsOrContentContains(keyword);
        }catch(Exception e){
            throw new SystemException(SERVICE_NAME, e.getMessage());
        }
        return checkItems;
    }

    public boolean CheckItemExist(CheckItem checkItem){
        String title = checkItem.getTitle();
        String content = checkItem.getContent();
        //判断相同标题的检查项目是否存在
        if(checkItemRepository.findByTitle(title) != null){
            return true;
        }
        else if(checkItemRepository.findByContent(content) != null) {
            return true;
        }
        else{
            return false;
        }
    }
}
