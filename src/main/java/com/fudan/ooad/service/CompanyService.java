package com.fudan.ooad.service;

import com.fudan.ooad.entity.*;
import com.fudan.ooad.exception.BaseException;
import com.fudan.ooad.exception.InvalidOperationException;
import com.fudan.ooad.exception.NullEntityException;
import com.fudan.ooad.repository.CheckItemRepository;
import com.fudan.ooad.repository.CheckTaskRepository;
import com.fudan.ooad.repository.CompanyRepository;
import com.fudan.ooad.repository.TaskProcessRepository;
import com.fudan.ooad.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Set;

/**
 * Created by Jindiwei on 2017/6/19.
 */
@Service
public class CompanyService implements ICompanyService {

    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private CheckItemRepository checkItemRepository;

    @Autowired
    private CheckTaskRepository checkTaskRepository;

    @Autowired
    private TaskProcessRepository taskProcessRepository;

    private final String SERVICE_NAME = "CompanyService";

    @Override
    public void setCheckItemState(Company company, CheckTask checkTask, CheckItem checkItem, ItemState itemState) throws BaseException{
        if(!companyRepository.exists(company.getId())){
            throw new NullEntityException(
                    SERVICE_NAME,
                    "The Company does not exist in the system, but it should be in the system."
            );
        }
        if(!checkTaskRepository.exists(checkTask.getId())){
            throw new NullEntityException(
                    SERVICE_NAME,
                    "The Checktask does not exist in the system."
            );
        }
        if (!checkItemRepository.exists(checkItem.getId())) {
            throw new NullEntityException(
                    SERVICE_NAME,
                    "The checkItem does not exist in database."
            );
        }
        Date cur = DateUtil.getCurrentDate();
        if(cur.after(checkTask.getDeadline())){
            throw new InvalidOperationException(
                    SERVICE_NAME,
                    "Current data is after deadline, can not set the state."
            );
        }
        if(itemState.toString().equals("已检查")){
            TaskProcess taskProcess = taskProcessRepository.findByCheckTaskAndCompany(checkTask, company);
        }
        else{
            throw new InvalidOperationException(
                    SERVICE_NAME,
                    "You can only set the state to finished."
            );
        }
        checkTask

    }

    /**
     * @param company 公司对象
     * @return 该公司需要检查的事务列表
     */
    @Override
    public Set<TaskProcess> getTaskProcesses(Company company) {
        return null;
    }

    /**
     * @param company   公司对象
     * @param checkTask 检查事务
     * @return 某项事务内相关项目的检查情况
     */
    @Override
    public TaskProcess getCheckItemsInTask(Company company, CheckTask checkTask) {
        return null;
    }
}
