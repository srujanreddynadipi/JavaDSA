package com.prepInsta.java.collections.linkedList;

public class Main {
    public static void main(String[] args) {
        Album album1 = new Album("Album 1");
        album1.addSong("Song 1", 3.5);
        album1.addSong("Song 2", 4.0);
        album1.addSong("Song 3", 2.5);

        Album album2 = new Album("Album 2");
        album2.addSong("Song 4", 3.0);
        album2.addSong("Song 5", 5.5);

        Playlist playlist = new Playlist();
        playlist.addSongToPlaylist(album1.getSongs().get(0));
        playlist.addSongToPlaylist(album2.getSongs().get(1));
        playlist.addSongToPlaylist(album1.getSongs().get(2));
        playlist.addSongToPlaylist(album2.getSongs().get(0));

        playlist.play();
    }
}
