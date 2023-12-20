class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
        Arrays.sort(tokens);
        int score=0;
        int maxScore=0;
        int left=0;
        int right=tokens.length-1;
        while(left<=right){
            if(tokens[left]<=power){
                power-=tokens[left];
                score+=1;
                maxScore=Math.max(score,maxScore);
                left++;
            }
            else if(score>0){
                power+=tokens[right];
                score-=1;
                right--;
            }
            else{
                break;
            }
        }
        return maxScore;
    }
}