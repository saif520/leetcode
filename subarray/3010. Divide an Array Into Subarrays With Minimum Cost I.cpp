class Solution {
public:
    int minimumCost(vector<int>& nums) {
        int n=nums.size();
        int s=nums[0];
        sort(nums.begin()+1,nums.end());
        s=s+nums[1]+nums[2];
        return s;
    }
};