class Solution {
public:
    static bool cmp(vector<int>&a,vector<int>&b){
        return b[1]>a[1];
    }
    int eraseOverlapIntervals(vector<vector<int>>& intervals) {
        sort(intervals.begin(),intervals.end(),cmp);
        int total=0;
        int last=-60000;
        int n=intervals.size();
        for(int i=0;i<n;i++){
            if(intervals[i][0]>=last){
                last=intervals[i][1];
            }
            else{
                total++;
            }
        }
        return total;
    }
};