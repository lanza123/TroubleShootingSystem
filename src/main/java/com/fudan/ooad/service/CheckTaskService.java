package com.fudan.ooad.service;

import com.fudan.ooad.entity.CheckTask;
import com.fudan.ooad.entity.Company;
import com.fudan.ooad.entity.TaskProcess;
import com.fudan.ooad.entity.Template;

import java.util.Set;

/**
 * Created by Jindiwei on 2017/6/19.
 */
public class CheckTaskService{
    /**
     * @param checkTask 待添加公司的事务
     * @param company   要添加的公司
     */
    
    public void addCompany(CheckTask checkTask, Company company) {

    }

    /**
     * @param checkTask 待添加公司的事务
     * @param companies 要添加的公司列表
     */
    
    public void checkTaskAddCompanies(CheckTask checkTask, Set<Company> companies) {

    }

    /**
     * @param checkTask 待删除公司的事务
     * @param company   要删除的公司
     */
    
    public void checkTaskDeleteCompany(CheckTask checkTask, Company company) {

    }

    
    public Set<Company> getCompanies(CheckTask checkTask) {
        return null;
    }

    
    public Set<CheckTask> getCheckItemsInCheckTask(CheckTask checkTask) {
        return null;
    }

    
    public Set<TaskProcess> getTaskProcess(CheckTask checkTask) {
        return null;
    }

    /**
     * @param template  待分发的模板
     * @param companies 待分发的公司列表
     */
    
    public void deliverTemplate(Template template, Set<Company> companies) {

    }
}
