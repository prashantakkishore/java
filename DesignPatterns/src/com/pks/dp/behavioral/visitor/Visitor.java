package com.pks.dp.behavioral.visitor;


import com.pks.dp.behavioral.visitor.model.Bank;
import com.pks.dp.behavioral.visitor.model.Company;
import com.pks.dp.behavioral.visitor.model.Resident;
import com.pks.dp.behavioral.visitor.model.Restaurant;

public interface Visitor {

    void visit(Bank bank);

    void visit(Company company);

    void visit(Resident resident);

    void visit(Restaurant restaurant);

}