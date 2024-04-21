package com.pks.dp.behavioral.observer.observer;

import com.pks.dp.behavioral.observer.observable.StocksObservable;

public class EmailAlertObserverImpl implements NotificationAlertObserver{

    String emailId;
    StocksObservable stocksObservable;

    public EmailAlertObserverImpl(String emailId, StocksObservable stocksObservable) {
        this.emailId = emailId;
        this.stocksObservable = stocksObservable;
    }

    @Override
    public void update() {
        sendMail(emailId, "product in stock hurry up");
    }

    private void sendMail(String emailId, String msg){
        System.out.println("mail sent to: " + emailId);
    }
}
