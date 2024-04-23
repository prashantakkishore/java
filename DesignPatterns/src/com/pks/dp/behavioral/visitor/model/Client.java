package com.pks.dp.behavioral.visitor.model;

import com.pks.dp.behavioral.visitor.Visitor;

public abstract class Client {

    private final String name;
    private final String address;

    public String getNumber() {
        return number;
    }

    public String getAddress() {
        return address;
    }

    public String getName() {
        return name;
    }

    private final String number;

    public Client(String name, String address, String number) {
        this.name = name;
        this.address = address;
        this.number = number;
    }

    public abstract void accept(Visitor visitor);

}