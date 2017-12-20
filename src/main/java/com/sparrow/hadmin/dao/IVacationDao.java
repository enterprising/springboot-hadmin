package com.sparrow.hadmin.dao;

import com.sparrow.hadmin.dao.support.IBaseDao;
import com.sparrow.hadmin.entity.Vacation;

import java.util.List;

/**
 * Created by peng.tan on 17/12/20.
 */
public interface IVacationDao extends IBaseDao<Vacation, Integer> {

    List<Vacation> findAll();

}
