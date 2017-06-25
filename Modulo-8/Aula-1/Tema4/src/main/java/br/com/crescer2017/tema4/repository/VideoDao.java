package br.com.crescer2017.tema4.repository;

import br.com.crescer2017.tema4.models.Video;
import javax.persistence.EntityManager;

public class VideoDao extends GenericDao<Video, Long> {
    public VideoDao(EntityManager entityManager) {
        super(Video.class, entityManager);
    }
}