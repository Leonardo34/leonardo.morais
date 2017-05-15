var seriesInvalidas = function(series) {
    return series.filter(isSerieInvalida)
        .map((s) => s.titulo)
        .toString();
};

var isSerieInvalida = (serie) => {
    var dateNow = new Date();
    if (serie.anoEstreia > dateNow.getFullYear()) {
        return true;
    }
    for (let key in serie) {
        if (serie[key] === null || typeof serie[key] === "undefined") {
            return true;
        }
    }
    return false;
};

console.log(seriesInvalidas(series));

// -----------------------------------------------------------------------------

var filtrarSeriesPorAno = (series, ano) => 
    series.filter(s => s.anoEstreia >= ano);

console.log(filtrarSeriesPorAno(series, 2015));

// ------------------------------------------------------------------------------

var mediaEpisodios = (series) => 
    series.reduce((total, serie) => 
        total + serie.numeroEpisodios, 0) / series.length;


console.log(mediaEpisodios(series));

// ---------------------------------------------------------------------------------

var procurarPorNome = (series, nome) => 
    series.some(s => s.elenco.indexOf(nome) >= 0);

console.log(procurarPorNome(series, "Leonardo Morais"));

// -------------------------------------------------------------------------------

var mascadaEmSerie = (serie) => 
    serie.elenco.length * 40000 + serie.diretor.length * 100000;


console.log(mascadaEmSerie(series[0]));

// -----------------------------------------------------------------------------------

var queroGenero = (gen, series) => 
    series.filter(s => s.genero.indexOf(gen) >= 0)
    .map(s => s.titulo);


console.log(queroGenero("Caos", series));

// ------------------------------------------------------------------------------------

var queroTitulo = (tit, series) => 
    series.filter(s => s.titulo.includes(tit))
    .map(s => s.titulo);


console.log(queroTitulo("The", series));

// ------------------------------------------------------------------------------------

var creditosIlluminatis = (serie) => {
    console.log("Titulo: ", serie.titulo);
    serie.diretor.sort(ordenarPorUltimoNome);
    serie.elenco.sort(ordenarPorUltimoNome);
    console.log("DIRETORES");
    serie.diretor.forEach(imprimir);
    console.log("ELENCO");
    serie.elenco.forEach(imprimir);
};

var imprimir = (elenco) => console.log(elenco);

var ordenarPorUltimoNome = (a, b) => {
    let splitA = a.trim().split(" ");
    let splitB = b.trim().split(" ");
    let ultimoNomeA = splitA[splitA.length - 1];
    let ultimoNomeB = splitB[splitB.length - 1];
    return ultimoNomeA.localeCompare(ultimoNomeB);
};

creditosIlluminatis(series[1]);

// ------------------------------------------------------------------------

var encontraSerieIlluminati = (series) => {
    var isSerieIlluminati = (serie) => {
        return serie.elenco.every(e => e.includes("."));
    };
    let seriesIlluminati = series.filter(isSerieIlluminati);
    let hashTag = "#";
    seriesIlluminati.forEach(
        (s) => s.elenco.forEach(
            e => hashTag += e.charAt(e.indexOf(".") - 1)
        )
    );
    return hashTag;
};

console.log(encontraSerieIlluminati(series));