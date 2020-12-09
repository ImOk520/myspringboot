package fengge.service;

import com.feng.pojo.Dept;

import java.util.List;

/**
 * Feng, Ge 2020-10-08 21:52
 */
public interface DeptService {

     boolean addDept(Dept dept);

     Dept queryById(Long deptno);

     void update(Long deptno);

     List<Dept> queryAll();

     void testTransaction(Long deptno);

}
