package br.com.crescer2017.tema01;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Parcelator implements IParcelator {

    @Override
    public Map<String, BigDecimal> calcular(BigDecimal valorParcelar, int numeroParcelas, double taxaJuros, Date dataPrimeiroVencimento) {
        Map<String, BigDecimal> parcelas = new TreeMap<>();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Calendar dataVencimento = Calendar.getInstance();
        dataVencimento.setTime(dataPrimeiroVencimento);
        for (int i = 0; i < numeroParcelas; i++) {
            parcelas.put(formatter.format(dataVencimento.getTime()),
                    valorParcelar.multiply(new BigDecimal(taxaJuros)));
            dataVencimento.add(Calendar.MONTH, 1);
        }
        return parcelas;
    }
}
