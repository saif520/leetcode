class Solution {
public:
    int maximumScore(int a, int b, int c) {
        priority_queue<int>maxheap;
        maxheap.push(a);
        maxheap.push(b);
        maxheap.push(c);
        int ans=0;

        while(maxheap.size()>0){
            int first=maxheap.top();
            maxheap.pop();
            int second=maxheap.top();
            maxheap.pop();

            if(first==0||second==0){
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