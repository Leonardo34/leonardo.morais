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

var mediaEpisodios = function(series) {
    return series.reduce((total, serie) => 
        total + serie.numeroEpisodios, 0) / series.length;
};

console.log(mediaEpisodios(series));

// ---------------------------------------------------------------------------------

var procurarPorNome = (series, nome) => 
    series.filter(s => s.elenco.indexOf(nome) >= 0).length > 0;

console.log(procurarPorNome(series, "Leonardo Morais"));

// -------------------------------------------------------------------------------

var mascadaEmSerie = (serie) => 
    serie.elenco.length * 40000 + serie.diretor.length * 100000;


console.log(mascadaEmSerie(series[0]));

// -----------------------------------------------------------------------------------

var queroGenero = (gen, series) => {
    return series.filter(s => s.genero.indexOf(gen) >= 0)
        .map(s => s.titulo);
};

console.log(queroGenero("Caos", series));

// ------------------------------------------------------------------------------------

var queroTitulo = (tit, series) => {
    return series.filter(s => s.titulo.includes(tit))
        .map(s => s.titulo);
};

console.log(queroTitulo("The", series));


