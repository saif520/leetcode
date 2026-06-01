// Q1.  Fibonacci series

import java.util.Scanner;

public class Main {

    public static int fibo(int n) {
        if (n <= 1) {
            return n;
        }

        int last = fibo(n - 1);
        int slast = fibo(n - 2);

        return last + slast;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the value of n:\t");
        int n = sc.nextInt();

        System.out.println(fibo(n));

        sc.close();
    }
}