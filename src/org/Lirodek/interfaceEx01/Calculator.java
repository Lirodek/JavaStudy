package org.Lirodek.interfaceEx01;

abstract class Calculator {
	
	public static int add(int a, int b) {
		return a+b;
	}

	
	public static int subtract(int c, int d) {
		// TODO Auto-generated method stub
		return c-d;
	}


	public static double average(int[] a) {
		int sum = 0;
		for(int i=0;i<a.length;i++) {
			sum+=a[i];
		}
		sum/=a.length;
		return sum;
	}
}
