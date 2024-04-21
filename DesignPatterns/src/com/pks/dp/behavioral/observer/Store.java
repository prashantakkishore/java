package com.pks.dp.behavioral.observer;

import com.pks.dp.behavioral.observer.observable.IphoneObservableImpl;
import com.pks.dp.behavioral.observer.observable.StocksObservable;
import com.pks.dp.behavioral.observer.observer.EmailAlertObserverImpl;
import com.pks.dp.behavioral.observer.observer.MobileAlertObserverImpl;
import com.pks.dp.behavioral.observer.observer.NotificationAlertObserver;

public class Store {

    public static void main(String[] args) {
        StocksObservable stocksObservable = new IphoneObservableImpl();
        NotificationAlertObserver observer = new EmailAlertObserverImpl("pks.c@sdsd.com", stocksObservable);
        NotificationAlertObserver observer2 = new EmailAlertObserverImpl("pks.d@sdsd.com", stocksObservable);
        NotificationAlertObserver observer3 = new MobileAlertObserverImpl("404-334-3420", stocksObservable);
        stocksObservable.add(observer);
        stocksObservable.add(observer2);
        stocksObservable.add(observer3);
        stocksObservable.setStockCount(200);
    }
}
