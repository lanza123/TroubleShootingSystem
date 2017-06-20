package com.fudan.ooad.service;

import com.fudan.ooad.entity.CheckItem;
import com.fudan.ooad.entity.CheckTask;
import com.fudan.ooad.entity.Company;
import com.fudan.ooad.entity.TaskProcess;
import com.fudan.ooad.exception.BaseException;

import java.util.Set;

/**
 * Created by Jindiwei on 2017/6/19.
 */
public interface ICompanyService {


    void setCheckItemState(Company company, CheckTask checkTask, CheckItem checkItem) throws BaseException;

    /**
     *
     * @param company 公司对象
     * @return 该公司需要检查的事务列表
     */
    Set<TaskProcess> getTaskProcesses(Company company);//获取每个公司对应的检查事务的List

    /**
     *
     * @param company 公司对象
     * @param checkTask 检查事务
     * @return 某项事务内相关项目的检查情况
     */
    TaskProcess getCheckItemsInTask(Company company, CheckTask checkTask); //获取某个检查事务的检查项目列表

}
