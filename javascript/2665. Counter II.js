/**
 * @param {integer} init
 * @return { increment: Function, decrement: Function, reset: Function }
 */
var createCounter = function(init) {
    let initialState=init;
    let increment=function(){
        initialState+=1;
        return initialState;
    }
    let decrement=function(){
        initialState-=1;
        return initialState;
    }
    let reset=function(){
        initialState=init;
        return initialState;
    }
    return {increment,decrement,reset};
};

/**
 * const counter = createCounter(5)
 * counter.increment(); // 6
 * counter.reset(); // 5
 * counter.decrement(); // 4
 */