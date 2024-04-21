package com.pks.dp.behavioral.observer.observer;

import com.pks.dp.behavioral.observer.observable.StocksObservable;

public class MobileAlertObserverImpl implements NotificationAlertObserver{

    String phoneNumber;
    StocksObservable stocksObservable;

    public MobileAlertObserverImpl(String phoneNumber, StocksObservable stocksObservable) {
        this.phoneNumber = phoneNumber;
        this.stocksObservable = stocksObservable;
    }

    @Override
    public void update() {
        sendMsgOnMobile(phoneNumber, "product in stock hurry up");
    }

    private void sendMsgOnMobile(String phoneNumber, String msg){
        System.out.println("msg sent to phone: " + phoneNumber);
    }
}
