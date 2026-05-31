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


//Q3. print N to 1

import java.util.Scanner;
public class Main
{
    static void fun(int i,int n){
        if(i<1){
            return;
        }
        System.out.println(i);
        fun(i-1,n);
    }
	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		
		System.out.print("Enter the the value of N: ");
		int n=sc.nextInt();
		
		fun(n,n);
		
	}
}

//Q4. Print 1 to N but used i+1 (use backtrack)

import java.util.Scanner;
public class Main
{
    static void fun(int i,int n){
        if(i<1){
            return;
        }
        
        fun(i-1,n);
        System.out.println(i);
        
    }
	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		
		System.out.print("Enter the the value of N: ");
		int n=sc.nextInt();
		
		fun(n,n);
		
	}
}

// //Q5. Print N to 1 but not used i-1 (use backtrack)

import java.util.Scanner;
public class Main
{
    static void fun(int i,int n){
        if(i>n){
            return;
        }
        
        fun(i+1,n);
        System.out.println(i);
        
    }
	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		
		System.out.print("Enter the the value of N: ");
		int n=sc.nextInt();
		
		fun(1,n);
		
	}
}