package com.pks.dp.structural.proxy;

public class EmployeeDaoProxy implements EmployeeDao{
    EmployeeDaoImpl employeeDao;

    public EmployeeDaoProxy(EmployeeDaoImpl employeeDao) {
        this.employeeDao = employeeDao;
    }

    @Override
    public void create(String client, Employee employee) {
        if (client.equals("USER"))
            System.out.println("Only admin can create");
        else employeeDao.create(client, employee);
    }

    @Override
    public Employee get(String client, int employeeId) {
        if (client.equals("USER")) {
            System.out.println("Only admin can get");
            return null;
        }
        else return employeeDao.get(client, employeeId);
    }

    @Override
    public void delete(String client, int employeeId) {
        if (client.equals("USER"))
            System.out.println("Only admin can delete");
        else employeeDao.delete(client, employeeId);
    }
}
