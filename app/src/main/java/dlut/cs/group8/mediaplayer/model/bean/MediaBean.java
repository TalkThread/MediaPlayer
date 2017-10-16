package dlut.cs.group8.mediaplayer.model.bean;

import java.io.Serializable;

/**
 * Created by Administrator on 2017-10-16.
 */

public class MediaBean implements Serializable{

    static final long serialVersionUID = 1L;

    public int id; //音频
    public String title; // 音频名称
    public String path; // 音频路径
    public long duration; // 音频时长
    public String albums; // 专辑
    public String artist; // 艺术家
    public long size; //音频大小

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public long getDuration() {
        return duration;
    }

    public void setDuration(long duration) {
        this.duration = duration;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAlbums() {
        return albums;
    }

    public void setAlbums(String albums) {
        this.albums = albums;
    }
}
