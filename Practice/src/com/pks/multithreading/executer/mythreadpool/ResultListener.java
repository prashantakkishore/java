package com.pks.multithreading.executer.mythreadpool;

public interface ResultListener<T> {

	public void finish(T obj);

	public void error(Exception ex);

}