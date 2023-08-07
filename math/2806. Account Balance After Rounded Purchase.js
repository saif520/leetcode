/**
 * @param {number} purchaseAmount
 * @return {number}
 */
var accountBalanceAfterPurchase = function(purchaseAmount) {
    let roundOff=(Math.floor((purchaseAmount+5)/10)*10);
    return 100-roundOff;
};