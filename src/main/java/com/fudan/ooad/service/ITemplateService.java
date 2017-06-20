package com.fudan.ooad.service;

import com.fudan.ooad.entity.CheckItem;
import com.fudan.ooad.entity.Template;

import java.util.Set;

/**
 * Created by Jindiwei on 2017/6/19.
 */
public interface ITemplateService {

    /**
     *
     * @param template 待添加项目的模板
     * @param checkItem 要添加的检查项目
     */
    void templateAddCheckItem(Template template, CheckItem checkItem);

    /**
     *
     * @param template 待删除项目的模板
     * @param checkItem 要删除的检查项目
     */
    void templateDeleteCheckItem(Template template, CheckItem checkItem);

    /**
     *
     * @param template 待创建的模板
     */
    void createTemplate(Template template);

    /**
     *
     * @param template 待修改的模板
     */
    void modifyTemplate(Template template);

    /**
     *
     * @param template 待删除的模板
     */
    void deleteTemplate(Template template);

    /**
     *
     * @param keyword 搜索关键词
     * @return 与关键词匹配的模板列表
     */
    Set<Template> searchTemplates(String keyword);
    Set<Template> getAllTempaltes();

}
