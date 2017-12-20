package com.sparrow.hadmin.service.impl;

import com.sparrow.hadmin.dao.IVacationDao;
import com.sparrow.hadmin.dao.support.IBaseDao;
import com.sparrow.hadmin.entity.Vacation;
import com.sparrow.hadmin.service.IVacationService;
import com.sparrow.hadmin.service.support.impl.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by peng.tan on 17/12/20.
 */
@Service public class VacationServiceImpl extends BaseServiceImpl<Vacation, Integer> implements IVacationService {

    @Autowired private IVacationDao vacationDao;

    @Autowired private IVacationService vacationService;

    @Override public List<Vacation> findAllVacation() {
        return null;
    }

    @Override public void saveOrUpdate(Vacation vacation) {
        if (vacation.getId() != null) {
            Vacation dbVacation = find(vacation.getId());
            dbVacation.setDescription(vacation.getDescription());
            dbVacation.setHomeNum(vacation.getHomeNum());
            dbVacation.setUser(vacation.getUser());
            dbVacation.setVacation_end(vacation.getVacation_end());
            dbVacation.setVacation_start(vacation.getVacation_start());
            update(dbVacation);
        } else {
            save(vacation);
        }
    }

    @Override public IBaseDao<Vacation, Integer> getBaseDao() {
        return null;
    }

    @Override public void delete(Integer integer) {
        super.delete(integer);
    }
}
