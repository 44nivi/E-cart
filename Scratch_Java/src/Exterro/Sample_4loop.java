package Exterro;

// write a program add the whole numbers from 1-10 , and find the sum the digits.
public class Sample_4loop {

	public static void main(String[] args) {
		int sum = 0;

		for (int i = 1; i <= 10; i++) {
			if (i % 2 == 0) {
				sum = sum + i;
			}
			System.out.println(sum);

		}
	}

}

// Looping: Repeating the set of instruction for a certain time unless the condition gets satisfied 
// eg: for (int i =1 ;i<10;i++)
//			{
//				System.out.print("nivi");
//			}
// o/p : 		* * * * * * * * *
// Entry contolled loop , Exit controlled loop 
// Entry controlled loop 
// eg:
//		int i =1;
//		while (i<10){
//		System.out.println("nivi");
//		i=i+1
//		}

//Exit controlled loop :
//	 int i =1
//	 do {
//	System.out.println("nivi");
//	i=i+1;
//		}while(i<10)		one time it will allow to run the exectuable stmt