var daisyGame = function(petalas) {
    if (petalas % 2) {
        return "Love Me";
    }
    return "Love Me Not";
};
console.log(daisyGame(4));
console.log(daisyGame(3));

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

var imprimir = function (nomes, callback) {
    for (var nome of nomes) {
        callback(nome);
    }
};
imprimir(
    ['bernardo', 'nunes', 'fabrício', 'ben-hur', 'carlos'], function(instrutor) {
        console.log("Ola querido instrutor: ", instrutor);
    }
);