package br.com.crescer2017.tema4.repository;

import br.com.crescer2017.tema4.models.Locacao;

public class LocacaoDao extends GenericDao<Locacao, Long> {
    public LocacaoDao() {
        super(Locacao.class);
    }
}
