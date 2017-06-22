package br.com.crescer2017.tema01;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;

public interface IParcelator {
    Map<String, BigDecimal> calcular(BigDecimal valorParcelar, int numeroParcelas, double taxaJuros, Date dataPrimeiroVencimento);
}
