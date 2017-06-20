package com.fudan.ooad.repository;

import com.fudan.ooad.entity.CheckTask;
import com.fudan.ooad.entity.Company;
import com.fudan.ooad.entity.TaskProcess;
import com.fudan.ooad.entity.TaskProcessState;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by zihao on 2017/6/18.
 */
public interface TaskProcessRepository extends JpaRepository<TaskProcess, Integer> {
    List<TaskProcess> findByTaskProcessState(TaskProcessState taskProcessState);
    TaskProcess findByCheckTaskAndCompany(CheckTask checkTask, Company company); // TODO 不一定正确
}
