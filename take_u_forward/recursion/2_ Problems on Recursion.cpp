// Print name N times using Recursion

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