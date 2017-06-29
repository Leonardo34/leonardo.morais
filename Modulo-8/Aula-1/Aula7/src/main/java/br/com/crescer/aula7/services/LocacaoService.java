package br.com.crescer.aula7.services;

import br.com.crescer.aula7.models.Locacao;
import br.com.crescer.aula7.repositorys.LocacaoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LocacaoService {
    
    @Autowired
    private LocacaoRepository locacaoRepositorio;
    
    public List<Locacao> list() {
        return (List) locacaoRepositorio.findAll();
    }
    
    public Locacao addGenero(Locacao locacao) {
        return locacaoRepositorio.save(locacao);
    }
    
    public void remove(Locacao locacao) {
        locacaoRepositorio.delete(locacao);
    }
    
    public Locacao getGeneroById(Long id) {
        return locacaoRepositorio.findOne(id);
    }
}
