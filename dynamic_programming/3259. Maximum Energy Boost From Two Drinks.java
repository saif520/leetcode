class Solution {
    public:
        long long maxEnergyBoost(vector<int>& v1, vector<int>& v2) {
            int n=v1.size();
            long long dp[n+1][2];
            memset(dp,-1,sizeof(dp));
            dp[0][0]=v1[0];
            dp[0][1]=v2[0];
            for(int i=1;i<n;i++){
                dp[i][0]=v1[i]+dp[i-1][0];
                dp[i][1]=v2[i]+dp[i-1][1];
                if(i-2>=0){
                    dp[i][0]=max(dp[i][0],v1[i]+dp[i-2][1]);
                    dp[i][1]=max(dp[i][1],v2[i]+dp[i-2][0]);
                }
            }
            return max(dp[n-1][0],dp[n-1][1]);
        }
    };