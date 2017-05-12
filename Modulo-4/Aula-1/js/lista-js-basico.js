var daisyGame = function(petalas) {
    if (petalas % 2) {
        return "Love Me";
    }
    return "Love Me Not";
};
console.log(daisyGame(4));
console.log(daisyGame(3));
// ----------------------------------------------------

var maiorTexto = function(textos) {
    var maiorPalavra = "";
    for (var texto of textos) {
        if (texto.length > maiorPalavra.length) {
            maiorPalavra = texto;
        }
    }
    return maiorPalavra;
};
console.log(maiorTexto(["Leonardo", "Morais", "Broch", "Leo", "Leozin"]));
console.log(maiorTexto(["NaN", "Not", "AAAA"]));
// -----------------------------------------------------

var imprimir = function (nomes, callback) {
    nomes.forEach(callback);
};
imprimir(
    ['bernardo', 'nunes', 'fabrício', 'ben-hur', 'carlos'], function(instrutor) {
        console.log("Ola querido instrutor: ", instrutor);
    }
);
// --------------------------------------------------------

var adicionar = function(a) {
    return (b) => a + b
}
console.log(adicionar(2)(2));

// ------------------------------------------------------------

var fiboSum = function(num) {
    var fibonacci = function(n) {
        if (n <= 2) {
            return 1;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }
    var sum = 0;
    for (var i = num; i >= 1; i--) {
        sum += fibonacci(i);
    }
    return sum;
}
console.log(fiboSum(7));
// ------------------------------------------------------------

var queroCafe = (mascada, precos) => 
    precos.filter((p) => p < mascada).sort().toString();

console.log(queroCafe(4, [5, 4, 3, 2, 1]));