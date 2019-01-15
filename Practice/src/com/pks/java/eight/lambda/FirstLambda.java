package com.pks.java.eight.lambda;

import java.io.File;
import java.io.FileFilter;
import java.util.stream.IntStream;

public class FirstLambda {

	public static void main(String[] args) {

		File dir = new File("D:/");

		// This can be replaced with Lambda because this has only 1 abstract method
//		FileFilter filter = new FileFilter() {
//			@Override
//			public boolean accept(File pathname) {
//				return pathname.getName().endsWith(".java");
//			}
//		};
		
		// Lambda of above anonymous class can be made by
		// 1 : Add method parameter Eg: (File pathname)
		// 2 : Add arrow syntax
		// 3 : Add return clause (For single line no need to write return keyword also)
		
		FileFilter filterLambda = (File pathname) -> pathname.getName().endsWith(".java");

		File[] javaFiles = dir.listFiles(filterLambda);
		IntStream.range(0, javaFiles.length).forEach(i -> System.out.println(javaFiles[i].getAbsolutePath()));

	}

}
