class Solution {
public:
    #define ll long long
    long long dividePlayers(vector<int>& skill) {
        int sz=skill.size();

        if(sz==0)return (skill[0]*skill[1]*1LL);

        ll ans=0;
        sort(begin(skill),end(skill));
        ll temp=skill[0]+skill[sz-1]*1LL;
        for(int i=0;i<sz/2;++i){
            ll mul=skill[i]*skill[sz-i-1]*1LL;
            ll add=skill[i]+skill[sz-i-1]*1LL;
            if(add!=temp)return -1;
            ans+=mul;
        }
        return ans;
    }
};