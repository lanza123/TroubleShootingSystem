package com.fudan.ooad.service;

import com.fudan.ooad.Exception.ItemNotExistException;
import com.fudan.ooad.entity.CheckItem;
import com.fudan.ooad.repository.CheckItemRepository;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Set;

/**
 * Created by Jindiwei on 2017/6/20.
 */
@SpringBootApplication
public class CheckItemService implements ICheckItemService {
    CheckItemRepository checkItemRepository;
    @Override
    public void addCheckItem(CheckItem checkItem) throws ItemNotExistException {
        //添加： 属性：title content
        // 1、title是否已存在
        // 2、content是否相同
        if(!CheckItemExist(checkItem)){
            checkItemRepository.save(checkItem);
        }
        else{
            throw new ItemNotExistException(this.getClass().getName());
        }
    }

    @Override
    public void modifyCheckItem(CheckItem checkItem){
        //检查是否有ID
        if(checkItem.getId() == null){
            //是一个新的检查项目
            addCheckItem(checkItem);
        }
        else{
            if(checkItemRepository.findOne(checkItem.getId()) != null){
                checkItemRepository.save(checkItem);
            }
            else{
                throw new ItemNotExistException(this.getClass().getName());
            }
        }
    }

    @Override
    public void deleteCheckItem(CheckItem checkItem) {
        //检查是否有ID
        if(checkItem.getId() == null){
            throw new ItemNotExistException(this.getClass().getName());// TODO 待检查
        }
        else{
            if(checkItemRepository.findOne(checkItem.getId()) != null){
                checkItemRepository.delete(checkItem.getId());
            }
            else{
                throw new ItemNotExistException(this.getClass().getName());
            }
        }
    }

    @Override
    public Set<CheckItem> searchCheckItem(String keyword) {
        return checkItemRepository.findByTitleContainsOrContentContains(keyword);
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
