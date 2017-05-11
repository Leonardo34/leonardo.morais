function soma(a, b) {
    return a + b;
};
console.log(soma(5, 5));

var somaDois = function(a, b) {
    return a + b;
};
console.log(somaDois(5, 5));

var somaTres = (a, b) => a + b
console.log(somaTres(5, 5));

console.log(somaTres(5, 5, 5));

console.log('carregou');