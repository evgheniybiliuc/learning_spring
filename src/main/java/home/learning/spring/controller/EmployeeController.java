package home.learning.spring.controller;

import home.learning.spring.model.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Controller
public class EmployeeController {
    private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);

    private Map<Integer, Employee> data = new HashMap<>();

    @RequestMapping(value = EMPRestUriConstants.DUMMY_EMP, method = RequestMethod.GET)
    @ResponseBody
    public Employee getDummyEmployee() {
        logger.info("Start getDummyEmployee");
        Employee employee = new Employee();
        employee.setId(9999);
        employee.setName("John Travolta");
        employee.setCreateDate(new Date());


        data.put(employee.getId(), employee);
        return employee;
    }

    @RequestMapping(value = EMPRestUriConstants.GET_EMP, method = RequestMethod.GET)
    @ResponseBody
    public Employee getEmployee(@PathVariable("id") int id) {
        logger.info("Start getEmployee.With id=" + id);
        return data.get(id);
    }


    @RequestMapping(value = EMPRestUriConstants.GET_ALL_EMP, method = RequestMethod.GET)
    @ResponseBody
    public List<Employee> getAllEmployees() {
        logger.info("Start getAllEmployees");
        return new ArrayList<>(data.values());
    }

    @RequestMapping(value = EMPRestUriConstants.CREATE_EMP, method = RequestMethod.POST)
    @ResponseBody
    public Employee createEmployee(@RequestBody Employee employee) {
        logger.info("Start create employee");
        employee.setCreateDate(new Date());
        data.put(employee.getId(), employee);
        return employee;
    }

    @RequestMapping(value = EMPRestUriConstants.DELETE_EMP, method = RequestMethod.PUT)
    @ResponseBody
    public Employee deleteEmployee(@PathVariable("id") int id) {
        logger.info("Start delete employee");
        return data.remove(id);
    }
}
