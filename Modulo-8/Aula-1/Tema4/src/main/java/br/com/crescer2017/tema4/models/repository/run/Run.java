package br.com.crescer2017.tema4.models.repository.run;

import br.com.crescer2017.tema4.models.Funcionario;
import br.com.crescer2017.tema4.models.repository.FuncionarioDao;

public class Run {
    public static void main(String[] args) {
        FuncionarioDao dao = new FuncionarioDao();
        Funcionario funcionario = new Funcionario();
        funcionario.setNome("Leonardo");
        funcionario.setRg("0123445667");
        dao.save(funcionario);
        System.out.println("Teste");           
    }
}
