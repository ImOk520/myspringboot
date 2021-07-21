package feng.service;

import com.feng.pojo.Dept;
import feng.dao.DeptDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Feng, Ge 2020-10-08 21:52
 */
@Service
public class DeptServiceIml implements DeptService{

    @Autowired
    private DeptDao deptDao;

    public boolean addDept(Dept dept) {
        return deptDao.addDept(dept);
    }

    public Dept queryById(Long deptno) {
        return deptDao.queryById(deptno);
    }

    public List<Dept> queryAll() {
        return deptDao.queryAll();
    }


    @Transactional(propagation = Propagation.NESTED)
    public void update(Long deptno) {
        deptDao.update(deptno);
    }

}
