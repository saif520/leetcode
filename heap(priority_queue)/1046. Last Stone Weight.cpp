class Solution {
public:
    int lastStoneWeight(vector<int>& stones) {
        priority_queue<int>maxheap;
        for(int i=0;i<stones.size();i++){
            maxheap.push(stones[i]);
        }
        while(maxheap.size()>1){
            int largestElement=maxheap.top();
            maxheap.pop();
            int secondLargest=maxheap.top();
            maxheap.pop();
            if(largestElement==secondLargest){
                continue;
            }
            else{
                int diff=largestElement-secondLargest;
                maxheap.push(diff);
            }
        }
        return maxheap.size()==0 ? 0 : maxheap.top();
    }
};