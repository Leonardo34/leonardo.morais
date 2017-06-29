package br.com.crescer.aula7.controllers;

import br.com.crescer.aula7.models.Locacao;
import br.com.crescer.aula7.services.LocacaoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LocacaoController {
    
    @Autowired
    private LocacaoService locacaoService;
    
    @GetMapping(value = "/locacao")
    public List<Locacao> listLocacoes() {
        return locacaoService.list();
    }
    
    @GetMapping(value = "/locacao/{id}")
    public Locacao getLocacao(@PathVariable Long id) {
        return locacaoService.getLocacaoById(id);
    }
    
    @PostMapping(value = "/locacao")
    public void addLocacao(@RequestBody Locacao locacao) {
        locacaoService.addLocacao(locacao);
    }
    
    @DeleteMapping(value = "/locacao/{id}")
    public void removeLocacao(@PathVariable Long id) {
        locacaoService.remove(locacaoService.getLocacaoById(id));
    }
    
    @PutMapping(value = "/locacao")
    public void updateGenero(@RequestBody Locacao locacao) {
        locacaoService.addLocacao(locacao);
    }
}
