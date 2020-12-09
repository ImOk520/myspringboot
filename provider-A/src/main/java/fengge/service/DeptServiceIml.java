package fengge.service;

import com.feng.pojo.Dept;
import fengge.dao.DeptDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Feng, Ge 2020-10-08 21:52
 */
@Slf4j
@Service
public class DeptServiceIml implements DeptService {

    @Autowired
    private DeptDao deptDao;

    public boolean addDept(Dept dept) {
        return deptDao.addDept(dept);
    }

    public Dept queryById(Long deptno) {
        Dept dept = deptDao.queryById(deptno);
        return dept;
    }

    public List<Dept> queryAll() {
        return deptDao.queryAll();
    }

    @Transactional
    public void testTransaction(Long deptno){
        update(deptno);
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void update(Long deptno) {
        deptDao.update(deptno);
    }
}
