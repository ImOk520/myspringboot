package feng.service;


import feng.entity.Dept;
import feng.entity.DeptExample;
import feng.mapper.DeptMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeptService {

    @Autowired
    private DeptMapper deptMapper;

    public List<Dept> list(){
        DeptExample example = new DeptExample();
        DeptExample.Criteria criteria = example.createCriteria();
        criteria.andDnameLike("%2%");
        return deptMapper.selectByExample(example);
    }
 }
