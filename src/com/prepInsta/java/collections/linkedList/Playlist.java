package com.prepInsta.java.collections.linkedList;

import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

class Playlist {
    private LinkedList<Song> playlist;
    private ListIterator<Song> playlistIterator;

    public Playlist() {
        this.playlist = new LinkedList<>();
        this.playlistIterator = playlist.listIterator();
    }

    public boolean addSongToPlaylist(Song song) {
        return playlist.add(song);
    }

    public void play() {
        if (playlist.isEmpty()) {
            System.out.println("Playlist is empty.");
            return;
        }

        Scanner scanner = new Scanner(System.in);
        boolean forward = true;
        boolean quit = false;

        printMenu();

        while (!quit) {
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 0:
                    System.out.println("Playlist complete.");
                    quit = true;
                    break;
                case 1:
                    if (!forward) {
                        if (playlistIterator.hasNext()) {
                            playlistIterator.next();
                        }
                        forward = true;
                    }
                    if (playlistIterator.hasNext()) {
                        System.out.println("Now playing " + playlistIterator.next());
                    } else {
                        System.out.println("End of playlist.");
                        forward = false;
                    }
                    break;
                case 2:
                    if (forward) {
                        if (playlistIterator.hasPrevious()) {
                            playlistIterator.previous();
                        }
                        forward = false;
                    }
                    if (playlistIterator.hasPrevious()) {
                        System.out.println("Now playing " + playlistIterator.previous());
                    } else {
                        System.out.println("Start of playlist.");
                        forward = true;
                    }
                    break;
                case 3:
                    if (forward) {
                        if (playlistIterator.hasPrevious()) {
                            System.out.println("Replaying " + playlistIterator.previous());
                            forward = false;
                        } else {
                            System.out.println("Start of playlist.");
                        }
                    } else {
                        if (playlistIterator.hasNext()) {
                            System.out.println("Replaying " + playlistIterator.next());
                            forward = true;
                        } else {
                            System.out.println("End of playlist.");
                        }
                    }
                    break;
                case 4:
                    printPlaylist();
                    break;
                case 5:
                    printMenu();
                    break;
            }
        }
    }

    private void printMenu() {
        System.out.println("Available actions:\npress");
        System.out.println("0 - to quit\n" +
                "1 - to play next song\n" +
                "2 - to play previous song\n" +
                "3 - to replay the current song\n" +
                "4 - to list songs in the playlist\n" +
                "5 - to print available actions");
    }

    private void printPlaylist() {
        System.out.println("Playlist:");
        for (Song song : playlist) {
            System.out.println(song);
        }
    }
}

