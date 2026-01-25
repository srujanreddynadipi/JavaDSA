package com.prepInsta.java.collections.linkedList;

import java.util.ArrayList;

public class Album {
    private String name ;
    private ArrayList<Song> songs ;

    public Album(String name) {
        this.name = name;
        this.songs = new ArrayList<>();
    }

    public  boolean addSong(String title , double duration){
        if(findSong(title) == null){
            songs.add(new Song(title , duration));
            return true;
        }
        return false;
    }

    public Song findSong(String title){
        for(Song song : songs){
            if(song.getTitle().equals(title)){
                return song;
            }
        }
        return null ;
    }

    public  ArrayList<Song> getSongs(){
        return songs;
    }
}
