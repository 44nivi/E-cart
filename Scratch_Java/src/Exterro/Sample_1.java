package Exterro;

import java.util.Scanner;

public class Sample_1 {

	public static void main(String[] args) {
//		System.out.println("hi nivi");
//		System.out.print("hello hi");
//		System.out.print("Good morning");
//		System.out.println("\t good eve");
//		System.out.println("\n adhithi");
//		int a = 4;
//		int b = 7;
//		int c = 9;
//		int d = 6;
//		int k = a + (b - c) * d;
//		System.out.println("the value of k is " + k);
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the breath ");
		float breath = scan.nextInt();
		System.out.println("enter the height ");
		float height = scan.nextInt();
		float Area = (breath * height) / 2;
		System.out.println("the area of triangle is " + Area);
		System.out.println("enter the radius of circle");
		int radius = scan.nextInt();
		double area = 3.14 * radius * radius;
		System.out.println("the area of circle" + area);

	}

}
