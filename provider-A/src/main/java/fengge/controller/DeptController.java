package fengge.controller;

import com.feng.pojo.Dept;
import fengge.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Feng, Ge 2020-10-08 21:57
 */
@RestController
@RequestMapping("/dept")
public class DeptController {

    @Autowired
    private DeptService deptService;

    @PostMapping("/add")
    public boolean add(@RequestBody Dept dept){
        return deptService.addDept(dept);
    }

    @GetMapping("/getById/{deptno}")
    public Dept getById(@PathVariable("deptno") Long deptno){
        Dept dept = deptService.queryById(deptno);
        return deptService.queryById(deptno);
    }

    @GetMapping("/getAll")
    public List<Dept> getAll(){
        return deptService.queryAll();
    }
}
