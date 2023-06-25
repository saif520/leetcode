/**
 * @param {number[]} nums
 * @return {number}
 */
var countBeautifulPairs = function(nums) {
    let count=0;
    for(let i=0;i<nums.length-1;i++){
        let first_digit;
        let a=nums[i];
        while(a>0){
            first_digit=a%10;
            a=Math.floor(a/10);
        }
        for(let j=i+1;j<nums.length;j++){
            if(gcd(first_digit,nums[j]%10)==1){
                count++;
            }
        }
    }
    return count;
};

function gcd(a, b) {
  	var divisor;
  	for (let i = 1; i <= a && i <= b; i++) {
    	if( a % i == 0 && b % i == 0) {
      		divisor = i;
    	}
  	}
  	return divisor;
}
