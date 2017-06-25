package br.com.crescer2017.tema4.models.repository.run;

import br.com.crescer2017.tema4.models.Genero;
import br.com.crescer2017.tema4.models.Video;
import br.com.crescer2017.tema4.repository.GeneroDao;
import br.com.crescer2017.tema4.repository.VideoDao;
import java.math.BigDecimal;
import java.util.ArrayList;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Run {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("localPU");
        EntityManager em = emf.createEntityManager();
        VideoDao dao = new VideoDao(em);
        GeneroDao genDao = new GeneroDao(em);
        Genero genero = genDao.loadById(new Long(8));
        System.out.println(genero.getDescricao());
        em.close();
        emf.close();
    }
}
