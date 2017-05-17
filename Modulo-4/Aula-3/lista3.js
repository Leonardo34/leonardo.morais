document.addEventListener('DOMContentLoaded', function() {
    let btnPesquisar = document.getElementById('btnPesquisar');
    btnPesquisar.onclick = function() {
        carregarPokemon(document.getElementById("idPokemon").value);
    }
});

var carregarPokemon = (pokemonId) => {
    let url = "http://pokeapi.co/api/v2/pokemon/" + pokemonId + "/";
    fetch(url).then(response => {
        response.json().then(json => {
            console.log(json);
            let pokemon = new Pokemon(json);
            pokemon.render();
        })
    });
    console.log(url);
};

