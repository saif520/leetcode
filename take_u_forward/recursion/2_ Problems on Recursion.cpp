//Q1. Print name N times using Recursion

#include <iostream>

void fun(int i,int n){
    if(i>n){
        return;
    }
    std::cout<<"Saifuddin\n";
    fun(i+1,n);
}

int main()
{
    int n;
    std::cout<<"Enter the value of N:\t";
    std::cin>>n;
    
    fun(1,n);

    return 0;
}

//Q2. Print 1 to N

#include <iostream>

void fun(int i,int n){
    if(i>n){
        return;
    }
    std::cout<<i<<"\n";
    fun(i+1,n);
}

int main()
{
    int n;
    std::cout<<"Enter the value of N:\t";
    std::cin>>n;
    
    fun(1,n);

    return 0;
}