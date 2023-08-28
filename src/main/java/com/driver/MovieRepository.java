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
        if (directMoviemap.containsKey(directorName)) {
            ArrayList temp = directMoviemap.get(directorName);
            temp.add(movieName);
            directMoviemap.put(directorName, temp);
        } else {
            ArrayList<String> temp = new ArrayList<>();
            temp.add(movieName);
            directMoviemap.put(directorName, temp);
        }


    }

    public List<String> getMoviesByDirectorName(String directorName) {
        return directMoviemap.get(directorName);
    }

    public List<String> findAllMovies() {
        List<String> temp = new ArrayList<>();
        for (String s : movieMap.keySet())
            temp.add(s);
        return temp;
    }


    public void deleteDirectorByName(String directorName) {
        directMoviemap.remove(directorName);
    }


    public void deleteAllDirectors() {
        for (String s:directMoviemap.keySet()){
            directMoviemap.remove(s);
        }
    }
}
