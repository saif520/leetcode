#include <iostream>
#include <vector>
using namespace std;

void subSeqSum(int ind,vector<int>&ds,int s,int sum,int arr[],int n){
    if(ind==n){
        if(s==sum){
            for(auto it:ds) cout<<it<<" ";
            cout<<endl;
        }
        return;
    }
    ds.push_back(arr[ind]);
    s+=arr[ind];
    
    subSeqSum(ind+1,ds,s,sum,arr,n);
    s-=arr[ind];
    ds.pop_back();
    
    //not pick
    subSeqSum(ind+1,ds,s,sum,arr,n);
}

int main(){
    int arr[]={1,2,1};
    int n=3;
    int sum=2;
    vector<int>ds;
    subSeqSum(0,ds,0,sum,arr,n);
    
    return 0;
}


//Q2. print any subsequence whose sum is equal to given sum

#include <iostream>
#include <vector>
using namespace std;

bool subSeqSum(int ind,vector<int>&ds,int s,int sum,int arr[],int n){
    if(ind==n){
        // condition satisfied
        if(s==sum){
            for(auto it:ds) cout<<it<<" ";
            cout<<endl;
            return true;
        }
        // condition not satisfied
        else return false;
    }
    ds.push_back(arr[ind]);
    s+=arr[ind];
    
    if(subSeqSum(ind+1,ds,s,sum,arr,n)==true){
        return true;
    }
    s-=arr[ind];
    ds.pop_back();
    
    //not pick
    if(subSeqSum(ind+1,ds,s,sum,arr,n)==true) return true;
    
    return false;
}

int main(){
    int arr[]={1,2,1};
    int n=3;
    int sum=2;
    vector<int>ds;
    subSeqSum(0,ds,0,sum,arr,n);
    
    return 0;
}

//Q3. count the subsequences with sum=k

#include <iostream>
#include <vector>
using namespace std;

int subSeqSum(int ind,int s,int sum,int arr[],int n){
    if(ind==n){
        // condition satisfied
        if(s==sum) return 1;
        // condition not satisfied
        else return 0;
    }
    
    s+=arr[ind];
    
    int l=subSeqSum(ind+1,s,sum,arr,n);
    
    s-=arr[ind];

    //not pick
    int r=subSeqSum(ind+1,s,sum,arr,n);
    
    return l+r;
}

int main(){
    int arr[]={1,2,1};
    int n=3;
    int sum=2;
    cout<<subSeqSum(0,0,sum,arr,n);
    
    return 0;
}