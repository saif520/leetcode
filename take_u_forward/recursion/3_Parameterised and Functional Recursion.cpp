//Q1. Sum of first N numbers (Parameterized Recursion)
#include <iostream>
using namespace std;
void sumFun(int i, int sum){
    if(i<1){
        cout<<sum;
        return;
    }
    sumFun(i-1,sum+i);
}

int main()
{
    int n=4;
    sumFun(n,0);
    return 0;
}

//Q1. Sum of first N numbers (Functional Recursion)

#include <iostream>
using namespace std;
int sum(int n){
    if(n==0){
        return 0;
    }
    return n + sum(n-1);
}

int main()
{
    int n=3;
    cout<<sum(n);
    return 0;
}


//Q2. Find factorial for a number (Functional Recursion)


#include <iostream>
using namespace std;
int fact(int n){
    if(n==0){
        return 1;
    }
    return n * fact(n-1);
}

int main()
{
    int n=3;
    cout<<fact(n);
    return 0;
}

