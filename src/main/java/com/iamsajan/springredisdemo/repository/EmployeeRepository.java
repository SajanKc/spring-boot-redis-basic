package com.iamsajan.springredisdemo.repository;

import com.iamsajan.springredisdemo.model.Employee;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Slf4j
public class EmployeeRepository {

    public static final String HASH_KEY = "Employee";
    private RedisTemplate redisTemplate;

    public EmployeeRepository(RedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    public Employee saveEmployee(Employee employee) {
        log.info("Saving employee with id: " + employee.getId());
        redisTemplate.opsForHash().put(HASH_KEY, employee.getId(), employee);
        return employee;
    }

    public List<Employee> getEmployees() {
        log.info("Getting all employees.");
        return redisTemplate.opsForHash().values(HASH_KEY);
    }

    public Employee getEmployeeById(String id) {
        log.info("Getting employee with id: " + id);
        return (Employee) redisTemplate.opsForHash().get(HASH_KEY, id);
    }

    public String deleteEmployee(String id) {
        log.info("Deleting employee with id: " + id);
        redisTemplate.opsForHash().delete(HASH_KEY, id);
        return "Empoyee with id: " + id + " deleted.";
    }
}
