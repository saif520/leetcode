class Solution {
public:
    int minOperations(vector<int>& nums, int k) {
        priority_queue<long,vector<long>,greater<long>>pq;
        for(int i=0;i<nums.size();i++){
            pq.push(nums[i]);
        }
        
        int ans=0;
        while(pq.top()<k){
            if(pq.top()<k){
                long long x=pq.top();
                pq.pop();
                long long y=pq.top();
                pq.pop();
                long long xy=x*2+y;
                pq.push(xy);
            }
            ans++;
        }
        
        return ans;
    }
};