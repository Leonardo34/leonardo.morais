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

