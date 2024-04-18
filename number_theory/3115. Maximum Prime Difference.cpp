class Solution {
public:
    int maximumPrimeDifference(vector<int>& nums) {
        vector<int>primes(101,true);
        primes[0]=false;
        primes[1]=false;

        for(int i=2;i<=100;i++){
            if(primes[i]){
                for(int j=i*2;j<=100;j+=i){
                    primes[j]=false;
                }
            }
        }

        int l=-1, r=-1;
        for(int i=0;i<nums.size();i++){
            if(primes[nums[i]]){
                l=i;
                break;
            }
        }

        for(int i=nums.size()-1;i>=0;i--){
            if(primes[nums[i]]){
                r=i;
                break;
            }
        }

        return r-l;
    }
};