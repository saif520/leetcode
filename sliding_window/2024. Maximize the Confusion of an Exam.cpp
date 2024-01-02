class Solution {
public:
    int maxConsecutiveAnswers(string s, int k) {
        int ans=0;
        int r=0,l=0;
        int cnt=0;
        while(r<s.length())
        {
            if(s[r]=='T')
                cnt++;
 
            while(cnt>k)
            {
                if(s[l]=='T')
                    cnt--;
 
                l++;
            }
 
            ans=max(ans,r-l+1);
            r++;
        }
 
        cnt=0;
        l=0;
        r=0;
        while(r<s.length())
        {
            if(s[r]=='F')
                cnt++;
 
            while(cnt>k)
            {
                if(s[l]=='F')
                    cnt--;
 
                l++;
            }
 
            ans=max(ans,r-l+1);
            r++;
        }
 
        return ans;
    }
};