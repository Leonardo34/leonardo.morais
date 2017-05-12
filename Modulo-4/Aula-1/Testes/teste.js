describe('Teste de daisyGame', function() {
    it('daisyGame com numero par', function() {
        expect(daisyGame(6)).toEqual("Love Me Not");
    });
    it('daisyGame com numero impar', function() {
        expect(daisyGame(5)).toEqual("Love Me");
    });
});

describe('Teste do maior texto em um array', function() {
    it('MaiorTexto deve retornar a maior string do array', function() {
        expect(maiorTexto(["Leonardo", "Leozin", "AAA"])).toEqual("Leonardo");
    });
})