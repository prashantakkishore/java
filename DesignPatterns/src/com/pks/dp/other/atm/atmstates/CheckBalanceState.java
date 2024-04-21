package com.pks.dp.other.atm.atmstates;

import com.pks.dp.other.atm.ATM;
import com.pks.dp.other.atm.Card;

public class CheckBalanceState extends ATMState {

    public CheckBalanceState() {
    }

    @Override
    public void displayBalance(ATM atm, Card card) {
        System.out.println("Your Balance is: " + card.getBankBalance());
        exit(atm);
    }

    @Override
    public void exit(ATM atmObject) {
        returnCard();
        atmObject.setCurrentATMState(new IdleState());
        System.out.println("Exit happens");
    }

    @Override
    public void returnCard() {
        System.out.println("Please collect your card");
    }
}
