package Exterro;

public class Contional_Statements {

	public static void main(String[] args) {

		int a = 8;
		int b = 7;
		int c = 4;
//		if (a > b) {
//			System.out.println(a + " is greater");
//		} else if (a < b) {
//			System.out.println(b + " is greater");
//		} else if (a == 7) {
//			System.out.println(" equal to 7");
//		} else if (b == 7) {
//			System.out.println(b + "equal to 7");
//		} else {
//			System.out.println("both the values are equal");
//		}

		if (a > b && a > c) {
			// System.out.println(a + " is greater");
			if (b > c) {
				System.out.println(c + "<" + b + "<" + a);
			} else {
				System.out.println(b + "<" + c + "<" + a);
			}
		} else if (b > a && b > c) {
			// System.out.println(b + " is greater");
			if (a > c) {
				System.out.println(c + "<" + a + "<" + b);
			} else {
				System.out.println(a + c + b);
			}
		} else {
			// System.out.println(c + " is greater ");
			if (a > b) {
				System.out.println(b + "<" + a + "<" + c);
			} else {
				System.out.println(a + "<" + b + "<" + c);

			}
		}

	}
}
