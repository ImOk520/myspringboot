package feng.service;

import com.feng.pojo.Dept;

import java.util.List;

/**
 * Feng, Ge 2020-10-08 21:52
 */
public interface DeptService {

     boolean addDept(Dept dept);

     Dept queryById(Long deptno);

     List<Dept> queryAll();

}
