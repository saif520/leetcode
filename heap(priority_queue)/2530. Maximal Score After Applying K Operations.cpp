class Solution {
public:
    long long maxKelements(vector<int>& nums, int k) {
        priority_queue<long long>pq;
        
        long long maxscore=0;

        for(int i=0;i<nums.size();i++){
            pq.push(nums[i]);
        }
        while(k--){
            double max=pq.top();
            maxscore+=max;
            pq.pop();
            max=ceil(max/3);
            pq.push(max);
            
        }
        return maxscore;
    }
};