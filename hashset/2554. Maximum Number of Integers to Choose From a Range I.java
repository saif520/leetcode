class Solution {
    public int maxCount(int[] banned, int n, int maxSum) {
        int ans = 0;
        int sum = 0;
        // Set<Integer> bannedSet = Arrays.stream(banned).boxed().collect(Collectors.toSet());
        HashSet<Integer>set=new HashSet<>();
        for(int i=0;i<banned.length;i++){
            set.add(banned[i]);
        }
        System.out.print(set);

        for(int i=1;i<=n;i++){
            if(!set.contains(i)&&sum+i<=maxSum){
                ans++;
                sum+=i;
            }
        }
        return ans;
    }
}