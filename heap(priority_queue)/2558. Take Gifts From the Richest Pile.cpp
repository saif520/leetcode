class Solution {
public:
    #define ll long long
    long long pickGifts(vector<int>& gifts, int k) {
        priority_queue<ll>pq(begin(gifts),end(gifts));
        ll ans=0;
        while(k){
            ll temp=sqrt(pq.top());
            pq.pop();
            pq.push(temp);
            --k;
        }
        while(!pq.empty()){
            ans+=pq.top();
            pq.pop();
        }
        return ans;
    }
};