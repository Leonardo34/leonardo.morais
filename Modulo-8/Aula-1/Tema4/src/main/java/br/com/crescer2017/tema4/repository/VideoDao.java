package br.com.crescer2017.tema4.models.repository;

import br.com.crescer2017.tema4.models.Video;

public class VideoDao extends GenericDao<Video, Long> {
    public VideoDao() {
        super(Video.class);
    }
}