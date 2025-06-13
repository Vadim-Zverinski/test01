package org.example.jd2;

public class User {
    String mail;
    Playlist playlist;

    public User(String mail, Playlist playlist) {
        this.mail = mail;
        this.playlist = playlist;
    }

    public Playlist getPlaylist() {
        return playlist;
    }

    public void setPlaylist(Playlist playlist) {
        this.playlist = playlist;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public User(String mail) {
        this.mail = mail;
    }
}
