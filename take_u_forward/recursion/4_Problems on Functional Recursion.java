//Q1. Reverse an array using recursion

import java.util.Scanner;
class Main {
    
    public static void fun(int i, int arr[],int n){
        if(i>=n/2) return;
        int temp=arr[i];
        arr[i]=arr[n-i-1];
        arr[n-i-1]=temp;
        fun(i+1,arr,n);
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the size of the array:\t");
        int n=sc.nextInt();
        System.out.print("Enter the element in the array:\t");
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        fun(0,arr,n);
        System.out.print("Array element after swap:\t");
        for(int i=0;i<n;i++){
            System.out.print(arr[i]+" ");
        }
    }
}


//Q1. Check if string is palindrome or not using recursion

import java.util.Scanner;
class Main {
    public static boolean fun(int i, String s){
        if(i>=s.length()/2) return true;
        if(s.charAt(i)!=s.charAt(s.length()-i-1)) return false;
        return fun(i+1,s);
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter a string:\t");
        String s=sc.next();
        System.out.println(fun(0,s));
    }
}