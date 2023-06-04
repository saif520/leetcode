class Solution {
public:
    vector<vector<int>> kClosest(vector<vector<int>>& points, int k) {
        priority_queue<pair<int,pair<int,int>>>maxheap;
        int n=points.size();
        for(int i=0;i<n;i++){
            maxheap.push({points[i][0]*points[i][0]+points[i][1]*points[i][1],{points[i][0],points[i][1]}});
            if(maxheap.size()>k){
                maxheap.pop();
            }
        }
        vector<vector<int>>ans;
        while(maxheap.size()>0){
            pair<int,int>p=maxheap.top().second;
            vector<int>temp;
            temp.push_back(p.first);
            temp.push_back(p.second);
            ans.push_back(temp);
            maxheap.pop();
        }
        
        return ans;
    }
};