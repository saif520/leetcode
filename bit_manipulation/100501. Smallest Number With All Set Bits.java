class Solution {
    public:
        int smallestNumber(int n) {
            int p=log2(n);
            int x=pow(2,p);
            if(x-1==n) return x-1;
            return 2*x-1;
        }
    };