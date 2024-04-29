package com.pks.dp.structural.proxy;

public class Main {
    public static void main(String[] args) {
        EmployeeDao employeeDao = new EmployeeDaoProxy(new EmployeeDaoImpl());
        employeeDao.create("USER", new Employee());
    }
}
