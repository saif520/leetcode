class Solution:
    def beautifulSubstrings(self, s: str, k: int) -> int:
        N=len(s)
        
        count=0;
        for i in range(N):
            v=c=0
            for j in range(i,N):
                if s[j] in "aeiou":
                    v+=1;
                else:
                    c+=1;
                if(v==c) and (v*c)%k==0:
                    count+=1
        return count;