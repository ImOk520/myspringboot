package fengge.dao;

import com.feng.pojo.Dept;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Feng, Ge 2020-10-08 21:36
 */
@Mapper
@Repository
public interface DeptDao {

    boolean addDept(Dept dept);

    Dept queryById(Long deptno);

    int update(Long deptno);

    List<Dept> queryAll();

}
