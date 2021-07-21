package feng.controller;

import com.feng.pojo.Dept;
import feng.service.DeptService;
import feng.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.transaction.annotation.Propagation.REQUIRED;

/**
 * Feng, Ge 2020-10-08 21:57
 */
@RestController
@RequestMapping("/dept")
public class DeptController {

    @Autowired
    private DeptService deptService;
    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/add")
    public boolean add(@RequestBody Dept dept){
        return deptService.addDept(dept);
    }

    @GetMapping("/getById/{deptno}")
    public Dept getById(@PathVariable("deptno") Long deptno){
        return deptService.queryById(deptno);
    }

    @GetMapping("/getAll")
    public List<Dept> getAll(){
        return deptService.queryAll();
    }

    @PostMapping("/test68")
    @Transactional(propagation=REQUIRED)
    public void test68(Long deptno) {
        deptService.update(1L);
        employeeService.update();
        deptService.update(2L);
    }
}
