package br.com.crescer.aula7.services;

import br.com.crescer.aula7.models.Funcionario;
import br.com.crescer.aula7.repositorys.FuncionarioRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FuncionarioService {
    
    @Autowired
    private FuncionarioRepository funcionarioRepositorio;
    
    public List<Funcionario> list() {
        return (List) funcionarioRepositorio.findAll();
    }
    
    public Funcionario addFuncionario(Funcionario funcionario) {
        return funcionarioRepositorio.save(funcionario);
    }
    
    public void remove(Funcionario funcionario) {
        funcionarioRepositorio.delete(funcionario);
    }
    
    public Funcionario getFuncionarioById(Long id) {
        return funcionarioRepositorio.findOne(id);
    }
}
