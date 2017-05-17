class Pokemon {
    constructor(json) {
        this.json = json;
    }

    render() {
        let div = document.getElementById("detalhesPokemon");
        let image = document.createElement("img");
        image.src = this.json.sprites.front_default;
        let name = document.createElement("h1");
        name.innerText = this.json.name;
        let number = document.createElement("h4");
        number.innerText = this.json.id;
        let lista = document.createElement("ul");
        this.json.types.forEach(type => {
            let item = document.createElement("li");
            item.innerHTML = type.type.name;
            lista.appendChild(item);
        });
        div.appendChild(name);
        div.appendChild(number);
        div.appendChild(image);
        div.appendChild(lista);
    }
}