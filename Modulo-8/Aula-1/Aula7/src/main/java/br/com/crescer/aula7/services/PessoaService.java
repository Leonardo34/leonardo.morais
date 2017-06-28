package br.com.crescer.aula7.services;

import br.com.crescer.aula7.models.Pessoa;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class PessoaService {
    private List<Pessoa> pessoas = new ArrayList<>();

    public List<Pessoa> list() {
        return pessoas;
    }
    
    public void add(Pessoa pessoa) {
        pessoas.add(pessoa);
    }
}
