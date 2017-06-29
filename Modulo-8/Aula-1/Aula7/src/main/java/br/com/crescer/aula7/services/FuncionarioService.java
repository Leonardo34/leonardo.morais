package br.com.crescer.aula7.services;

import br.com.crescer.aula7.models.Funcionario;
import br.com.crescer.aula7.repositorys.FuncionarioRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

public class FuncionarioService {
    @Autowired
    private FuncionarioRepository funcionarioRepositorio;
    
    public List<Funcionario> list() {
        return (List) funcionarioRepositorio.findAll();
    }
    
    public Funcionario addGenero(Funcionario funcionario) {
        return funcionarioRepositorio.save(funcionario);
    }
    
    public void remove(Funcionario funcionario) {
        funcionarioRepositorio.delete(funcionario);
    }
    
    public Funcionario getGeneroById(Long id) {
        return funcionarioRepositorio.findOne(id);
    }
}
