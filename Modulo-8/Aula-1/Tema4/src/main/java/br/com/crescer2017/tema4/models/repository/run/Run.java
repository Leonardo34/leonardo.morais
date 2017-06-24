package br.com.crescer2017.tema4.models.repository.run;

import br.com.crescer2017.tema4.models.Genero;
import br.com.crescer2017.tema4.models.Video;
import br.com.crescer2017.tema4.repository.GeneroDao;
import br.com.crescer2017.tema4.repository.VideoDao;
import java.math.BigDecimal;
import java.util.ArrayList;

public class Run {
    public static void main(String[] args) {
        VideoDao dao = new VideoDao();
        GeneroDao genDao = new GeneroDao();
        Genero genero = genDao.loadById(new Long(8));
        Video video = new Video();
        video.setDuracao("TESTE");
        video.setValor(BigDecimal.ZERO);
        video.setGenero(genero);
        genero.setVideos(new ArrayList<>());
        genero.getVideos().add(video);
        genDao.save(genero);
        System.out.println(genero.getDescricao());
    }
}
