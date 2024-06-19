class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        int start=Integer.MAX_VALUE;
        int end=Integer.MIN_VALUE;
        int n=bloomDay.length;

        for(int i=0;i<n;i++){
            start=Math.min(start,bloomDay[i]);
            end=Math.max(end,bloomDay[i]);
        }

        int ans=-1;
        int totalFlowers=m*k;
        if(totalFlowers>n){
            return ans;
        }

        while(start<=end){
            int mid=(start+end)/2;
            if(isPossible(bloomDay,mid,k,m)){
                ans=mid;
                end=mid-1;
            }
            else{
                start=mid+1;
            }
        }
        return ans;
    }
    public boolean isPossible(int arr[],int days,int k,int m){
        int n=arr.length;
        int count=0;
        int ans=0;
        for(int i=0;i<n;i++){
            if(arr[i]<=days){
                count++;
            }
            else{
                count=0;
            }
            if(count==k){
                ans++;
                count=0;
            }
        }
        return ans>=m;
    }
}