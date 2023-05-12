class Solution {
    public int distinctIntegers(int n) {
        // HashSet<Integer>set=new HashSet<>();
        TreeSet<Integer>set=new TreeSet<>();
        set.add(n);
        int count=1;
        int x=n;
        while(x>=1){
            int i=2;
            while(i<x){
                if(x%i==1){
                    set.add(i);
                }
                i++;
            }
            x--;
        }
        return set.size();
    }
}