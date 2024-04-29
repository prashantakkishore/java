package com.pks.dp.structural.proxy;

public class EmployeeDaoImpl implements EmployeeDao{

    @Override
    public void create(String client, Employee employee) {
        System.out.println("Created employee ...");
    }

    @Override
    public Employee get(String client, int employeeId) {
        System.out.println("Getting employee ...");
        return new Employee();
    }

    @Override
    public void delete(String client, int employeeId) {
        System.out.println("Deleted employee ...");
    }
}
