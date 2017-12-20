package com.sparrow.hadmin.service;

import com.sparrow.hadmin.entity.Vacation;

import java.util.List;

/**
 * 请假服务类
 * Created by peng.tan on 17/12/20.
 */
public interface IVacationService {


    List<Vacation> findAllVacation();

    /**
     * 新增或删除请假
     * @param vacation
     */
    void saveOrUpdate(Vacation vacation);

}
