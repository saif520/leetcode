//Q1. Reverse an array using recursion
#include <iostream>
using namespace std;

void fun(int i, int arr[], int n){
    if(i>=n/2) return;
    swap(arr[i],arr[n-i-1]);
    fun(i+1,arr,n);
}

int main()
{
    int n;
    cout<<"Enter the array size:\t";
    cin>>n;
    int arr[n];
    cout<<"Enter the element in the array:\t";
    for(int i=0;i<n;i++){
        cin>>arr[i];
    }
    
    fun(0,arr,n);
    
    for(int i=0;i<n;i++){
        cout<<arr[i]<<" ";
    }

    return 0;
}

//Q1. Check if string is palindrome or not using recursion

#include <iostream>
using namespace std;
bool fun(int i, string &s){
    if(i>=s.size()/2) return true;
    if(s[i]!=s[s.size()-i-1]) return false;
    return fun(i+1,s);
}

int main() {
    // Write C++ code here
    string s;
    cout << "Enter the string:\t";
    cin >> s;
    cout << fun(0,s);

    return 0;
}