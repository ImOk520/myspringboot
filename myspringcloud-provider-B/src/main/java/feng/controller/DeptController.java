package feng.controller;

import feng.entity.Dept;
import feng.service.DeptService;
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

    @GetMapping("/list")
    public List<Dept> list(){
        return deptService.list();
    }
}
