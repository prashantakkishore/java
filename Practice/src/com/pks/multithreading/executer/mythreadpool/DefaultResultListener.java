package com.pks.multithreading.executer.mythreadpool;

public class DefaultResultListener implements ResultListener{

	 @Override
	 public void finish(Object obj) {
	  
	 }

	 @Override
	 public void error(Exception ex) {
	  ex.printStackTrace();
	 }

	}