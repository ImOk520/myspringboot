package fengge.controller;

import fengge.dao.DeptDao;
import fengge.service.DeptService;
import fengge.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.io.*;

@Slf4j
@RequestMapping("/transaction")
@RestController
public class TransactionController {

    @Autowired
    private DeptService deptService;

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/test69")
    @Transactional
    public void test69 (Long deptno, String id) {
        deptService.update(deptno);
        employeeService.update();
    }

}
