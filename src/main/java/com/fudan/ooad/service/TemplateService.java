package com.fudan.ooad.service;

import com.fudan.ooad.entity.CheckItem;
import com.fudan.ooad.entity.Template;
import com.fudan.ooad.repository.CheckItemRepository;
import com.fudan.ooad.repository.TemplateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Jindiwei on 2017/6/19.
 */
@SpringBootApplication
public class TemplateService implements ITemplateService {

    @Autowired
    TemplateRepository templateRepository;

    @Autowired
    CheckItemRepository checkItemRepository;


    /**
     * @param template  待添加项目的模板
     * @param checkItem 要添加的检查项目
     */
    @Override
    public void templateAddCheckItem(Template template, CheckItem checkItem) {
        if(templateAlreadyExist(template)){
            if(!checkItemAlreadyInTemplate(template, checkItem)){
                template.addCheckItem(checkItem);
                templateRepository.save(template);
            }
            else{
                //TODO template 中已存在 checkItem
            }
        }
        else{
            //TODO template不存在
        }
    }

    /**
     * @param template  待删除项目的模板
     * @param checkItem 要删除的检查项目
     */
    @Override
    public void templateDeleteCheckItem(Template template, CheckItem checkItem) {
        if(checkItem.getId() == null){
            return;//TODO checkItem is note exist
        }
        else if(templateAlreadyExist(template)){
            // checkItem is in the template
            if(checkItemAlreadyInTemplate(template, checkItem)){
                Set<CheckItem> checkItemSet = template.getCheckItems();
                for(CheckItem item : checkItemSet){
                    if(checkItem.getId() == item.getId()){
                        // delete the item and return
                        checkItemSet.remove(item);
                        return;
                    }
                }
            }
            else{
                //TODO template 中不存在 checkItem
            }
        }
        else{
            //TODO template不存在
        }
    }

    /**
     * @param template 待创建的模板
     */
    @Override
    public void createTemplate(Template template) {
        if(!templateAlreadyExist(template)){
            templateRepository.save(template);
        }
        else{
            //TODO template already exist
        }
    }

    /**
     * @param template 待修改的模板
     */
    @Override
    public void modifyTemplate(Template template) {
        Integer id = template.getId();
        if(templateRepository.exists(id)){
            templateRepository.save(template);
        }
        else{
            //TODO template already exist
        }
    }

    /**
     * @param template 待删除的模板
     */
    @Override
    public void deleteTemplate(Template template) {
        Integer id = template.getId();
        //TODO 为添加判断模板是否被发放
        if(templateRepository.exists(id)){
            templateRepository.delete(id);
        }
        else{
            //TODO 不存在该模板
        }
    }

    /**
     * @param keyword 搜索关键词
     * @return 与关键词匹配的模板列表
     */
    @Override
    public Set<Template> searchTemplates(String keyword) {
        return templateRepository.findAllByTitleContainsOrDescriptionContains(keyword);
    }


    @Override
    public Set<Template> getAllTempaltes() {
        Set<Template> templates=new HashSet<Template>();
        templates.addAll(templateRepository.findAll());//给set填充
        return templates;
    }

    /**
     *
     * @param template 针对新创建的没有ID的Template
     * @return
     */
    public boolean templateAlreadyExist(Template template){
        String title = template.getTitle();
        String description = template.getDescription();
        //判断相同标题的检查项目是否存在
        if(templateRepository.findByTitle(title) != null){
            return true;
        }
        else if(templateRepository.findByDescription(description) != null) {
            return true;
        }
        else{
            return false;
        }
    }


    public boolean checkItemAlreadyInTemplate(Template template, CheckItem checkItem){
        Set<CheckItem> checkItems = template.getCheckItems();
        for (CheckItem item : checkItems) {
            if(checkItem.getId() == item.getId()){
                return true;
            }
        }
        return false;
    }


}
