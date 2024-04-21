package com.pks.dp.behavioral.observer.observable;

import com.pks.dp.behavioral.observer.observer.NotificationAlertObserver;

public interface StocksObservable {
    void add(NotificationAlertObserver observer);
    void remove(NotificationAlertObserver observer);
    void notifyObservers();
    void setStockCount(int newStockAdded);
    int getStockCount();

}
