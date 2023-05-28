/**
 * @param {number[]} prices
 * @param {number} money
 * @return {number}
 */
var buyChoco = function(prices, money) {
    prices=prices.sort(function(a,b){
        return a-b;
    })
    let i=0;
    let count=0;
    let sum=0;
    while(i<2){
       sum+=prices[i];
        i++;
    }
    if(money-sum>=0) return money-sum;
    return money;
};