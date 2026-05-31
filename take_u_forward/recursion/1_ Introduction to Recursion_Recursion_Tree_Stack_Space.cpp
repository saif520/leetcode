#include <iostream>
int cnt=0;
void countFun(){
    if(cnt==3){
        return;
    }
    std::cout<<cnt<<"\n";
    cnt++;
    countFun();
}

int main()
{
    countFun();
    return 0;
}