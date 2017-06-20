package com.fudan.ooad.service;

import com.fudan.ooad.entity.CheckTask;
import com.fudan.ooad.entity.Company;
import com.fudan.ooad.entity.TaskProcess;
import com.fudan.ooad.entity.Template;

import java.util.Set;

/**
 * Created by Jindiwei on 2017/6/19.
 */
public interface ICheckTaskService {

    /**
     *
     * @param checkTask 待添加公司的事务
     * @param company 要添加的公司
     */
    void addCompany(CheckTask checkTask, Company company);

    /**
     *
     * @param checkTask 待添加公司的事务
     * @param companies 要添加的公司列表
     */
    void checkTaskAddCompanies(CheckTask checkTask, Set<Company> companies);

    /**
     *
     * @param checkTask 待删除公司的事务
     * @param company 要删除的公司
     */
    void checkTaskDeleteCompany(CheckTask checkTask, Company company);

    /**
     *
     * @param checkTask 检查事务
     * @return 下发的企业列表
     */
    Set<Company> getCompanies(CheckTask checkTask);

    /**
     *
     * @param checkTask 检查事务
     * @return 检查事务对应使用的模板
     */
    Set<CheckTask> getCheckItemsInCheckTask(CheckTask checkTask);

    /**
     *
     * @param checkTask 检查事务
     * @return 返回该检查事务对应公司的状态
     */
    Set<TaskProcess> getTaskProcess(CheckTask checkTask);

    /**
     *
     * @param template 待分发的模板
     * @param companies 待分发的公司列表
     */
    void deliverTemplate(Template template, Set<Company> companies);


}
