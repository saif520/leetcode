//Q1. Sum of first N numbers (Parameterised Recursion)

class Main {
    public static void sum(int i,int sum){
        if(i<1){
            System.out.println(sum);
            return;
        }
        sum(i-1,sum+i);
    }
    public static void main(String[] args) {
        int n=4;
        sum(n,0);
    }
}

//Q1. Sum of first N numbers (Functional Recursion)
class Main {
    public static int sum(int n){
        if(n==0){
            return 0;
        }
        return n+sum(n-1);
    }
    public static void main(String[] args) {
        int n=3;
        System.out.println(sum(n));
    }
}

//Q2. Find factorial for a number
