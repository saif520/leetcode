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

// Q3. print N to 1

#include <iostream>

void fun(int i,int n){
    if(i<1){
        return;
    }
    std::cout<<i<<"\n";
    fun(i-1,n);
}

int main()
{
    int n;
    std::cout<<"Enter the value of N:\t";
    std::cin>>n;
    
    fun(n,n);

    return 0;
}

//Q4. Print 1 to N but not used i+1 (use backtrack)

#include <iostream>

void fun(int i,int n){
    if(i<1){
        return;
    }
    fun(i-1,n);
    std::cout<<i<<"\n";
    
}

int main()
{
    int n;
    std::cout<<"Enter the value of N:\t";
    std::cin>>n;
    
    fun(n,n);

    return 0;
}


//Q5. Print N to 1 but not used i-1 (use backtrack)

#include <iostream>

void fun(int i,int n){
    if(i>n){
        return;
    }
    fun(i+1,n);
    std::cout<<i<<"\n";
    
}

int main()
{
    int n;
    std::cout<<"Enter the value of N:\t";
    std::cin>>n;
    
    fun(1,n);

    return 0;
}