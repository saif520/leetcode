class Solution {
    public:
        int maxSatisfaction(vector<int>& satisfaction) {
            sort(satisfaction.begin(),satisfaction.end());
            int n=satisfaction.size();
            int total=0;
            int start=n-1;
            for(int i=n-1;i>=0;i--){
                total+=satisfaction[i];
                if(total<0){
                    break;
                }
                start--;
            }
            start++;
            int k=1;
            total=0;
            for(int i=start;i<n;i++){
                total+=(k++)*(satisfaction[i]);
            }
            return total;
        }
    };