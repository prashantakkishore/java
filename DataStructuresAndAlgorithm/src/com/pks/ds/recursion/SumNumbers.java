package com.pks.ds.recursion;

import java.util.ArrayList;
import java.util.LinkedList;

public class SumNumbers {

    public static void main(String[] args) {
        System.out.println(sumNum(10 ));
        LinkedList<Integer> l = new LinkedList();
        l.add(5);
        l.add(6);
        l.add(7);
        l.add(8);
        l.add(9);
        l.add(10);
        l.add(11);
        l.add(12);
        System.out.println(l.get(0));
    }

    public static int sumNum(Integer num) {
       if (num == 1)
           return 1;

        return sumNum(num -1 ) + num ;

    }
}
