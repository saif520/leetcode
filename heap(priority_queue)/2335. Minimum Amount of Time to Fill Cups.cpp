class Solution {
public:
    int fillCups(vector<int>& amount) {
        priority_queue<int>maxheap;
        for(int i=0;i<amount.size();i++){
            maxheap.push(amount[i]);
        }
        int ans=0;

        while(maxheap.size()>0){
            int first=maxheap.top();
            maxheap.pop();
            int second=maxheap.top();
            maxheap.pop();

            if(first<=0&&second<=0){
                break;
            }
            first--;
            second--;
            maxheap.push(first);
            maxheap.push(second);
            ans++;
        }
        return ans;
    }
};