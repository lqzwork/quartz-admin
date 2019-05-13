package com.ffxl.test;

public class Teee {

	public static void main(String[] args) {
		int a = 10>>1;
		int b = a++;
		int c = ++a;
		int d = b * a++;
		System.out.println(a);
		System.out.println(b);
		System.out.println(c);
		System.out.println(d);

	}
}
