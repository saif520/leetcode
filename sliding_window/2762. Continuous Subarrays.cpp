class Solution {
public:
    long long continuousSubarrays(vector<int>& nums) {
        int n=nums.size();
        long long ans=0;
        deque<int>maxQ;
        deque<int>minQ;
        int l=0;
        int r=0;
        while(r<n){
            while(!maxQ.empty()&&nums[r]>maxQ.back()){
                maxQ.pop_back();
            }
            while(!minQ.empty()&&nums[r]<minQ.back()){
                minQ.pop_back();
            }
            maxQ.push_back(nums[r]);
            minQ.push_back(nums[r]);

            while(maxQ.front()-minQ.front()>2){
                if(nums[l]==maxQ.front()){
                    maxQ.pop_front();
                }
                if(nums[l]==minQ.front()){
                    minQ.pop_front();
                }
                l++;
            }
            ans+=r-l+1;
            r++;
        }
        return ans;
    }
};