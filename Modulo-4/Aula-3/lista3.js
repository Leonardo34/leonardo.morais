document.addEventListener('DOMContentLoaded', function() {
    let btnPesquisar = document.getElementById('btnPesquisar');
    btnPesquisar.onclick = function() {
        carregarPokemon(document.getElementById("idPokemon").value);
    }
});

var carregarPokemon = (pokemonId) => {
    console.log(pokemonId);
};