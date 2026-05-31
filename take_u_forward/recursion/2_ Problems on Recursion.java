// Print name N times using Recursion

import java.util.Scanner;
public class Main
{
    static void fun(int i,int n){
        if(i>n){
            return;
        }
        System.out.println("Saifuddin");
        fun(i+1,n);
    }
	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		
		System.out.print("Enter the the value of N: ");
		int n=sc.nextInt();
		
		fun(1,n);
		
	}
}


//Q2. Print 1 to N

import java.util.Scanner;
public class Main
{
    static void fun(int i,int n){
        if(i>n){
            return;
        }
        System.out.println(i);
        fun(i+1,n);
    }
	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		
		System.out.print("Enter the the value of N: ");
		int n=sc.nextInt();
		
		fun(1,n);
		
	}
}