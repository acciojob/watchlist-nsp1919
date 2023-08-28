package com.driver;

import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
public class MovieRepository {

    HashMap<String, Movie> movieMap;
    HashMap<String, Director> directorMap;
    HashMap<String, ArrayList<String>> directMoviemap;

    public MovieRepository() {
        this.movieMap = new HashMap<>();
        this.directorMap = new HashMap<>();
        this.directMoviemap = new HashMap<>();
    }

    public void addMovie(Movie movie) {
        movieMap.put(movie.getName(), movie);
    }

    public Movie getMovieByName(String name) {

        return movieMap.get(name);
    }

    public void addDirector(Director director) {

        directorMap.put(director.getName(), director);
    }

    public Director getDirectorByName(String name) {
        return directorMap.get(name);
    }

    public void addMovieDirectorPair(String movieName, String directorName) {
        if (movieMap.containsKey(movieName)&& directorMap.containsKey(directorName)) {
            ArrayList<String> temp=new ArrayList<>();
            if (directMoviemap.containsKey(directorName)) temp=directMoviemap.get(directorName);
            temp.add(movieName);
            directMoviemap.put(directorName, temp);
        }
    }

    public List<String> getMoviesByDirectorName(String directorName) {
        ArrayList<String>temp=new ArrayList<>();
        if (directMoviemap.containsKey(directorName)){
            ArrayList temo=directMoviemap.get(directorName);
        }
        return temp;
    }

    public List<String> findAllMovies() {
        List<String> temp = new ArrayList<>();
        for (String s : movieMap.keySet())
            temp.add(s);
        return temp;
    }



    //we have to remove movies from moviemap and directormovie map
    public void deleteDirectorByName(String directorName) {
        ArrayList<String> temp=new ArrayList<>();
        if (directMoviemap.containsKey(directorName))
        {
            temp=directMoviemap.get(directorName);
            for (String s:temp){
                if (movieMap.containsKey((s)))
                    movieMap.remove(s);
            }
            directMoviemap.remove(directorName);
        }
    }

    public void deleteAllDirectors() {
        ArrayList<String> temp=new ArrayList<>();
        for (String dir:directMoviemap.keySet()){
            temp=directMoviemap.get(dir);
            for (String s:temp){
                if (movieMap.containsKey(s))
                    movieMap.remove(s);
            }
            if (directorMap.containsKey(dir))
                directorMap.remove(dir);
            directorMap.remove(dir);
        }


    }
}
