package fengge.service;

import fengge.dao.EmployeeDao;
import fengge.mapper.DataInitMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * Feng, Ge 2021/7/15 0015 14:18
 */
public class EmployeeServiceIml implements EmployeeService {

    @Autowired
    private DataInitMapper dataInitMapper;

    @Transactional(propagation = Propagation.NESTED)
    public void update() {
        dataInitMapper.update();
        int i = 10/0;
    }
}
