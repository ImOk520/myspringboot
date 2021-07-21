package feng.service;

import feng.dao.DataInitDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * Feng, Ge 2021/7/15 0015 14:18
 */
@Service
public class EmployeeServiceIml implements EmployeeService {

    @Autowired
    private DataInitDao dataInitDao;

    @Transactional(propagation = Propagation.NESTED)
    public void update() {
        dataInitDao.update();
        int i = 10/0;
    }
}
