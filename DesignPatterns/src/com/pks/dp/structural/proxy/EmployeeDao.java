package com.pks.dp.structural.proxy;

public interface EmployeeDao {
    void create(String client, Employee employee);
    Employee get(String client, int employeeId);
    void delete(String client, int employeeId);

}
