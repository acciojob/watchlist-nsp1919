package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {

    @Autowired
    MovieService movieService;

    @PostMapping("/add-movie")
    public ResponseEntity<String> addMovie(@RequestBody Movie movie){
        movieService.addMovie(movie);
        return new ResponseEntity<>("New movie added", HttpStatus.CREATED);
    }

    @GetMapping("get-movie-by-name/{name}")
    public ResponseEntity<Movie> getMovieByName(@PathVariable("name") String name){
        Movie m=movieService.getMovieByName(name);
        return new ResponseEntity<>(m,HttpStatus.FOUND);
    }


    @PostMapping("add-director")
    public ResponseEntity<String> addDirector(@RequestBody Director director){
        movieService.addDirector(director);
        return new ResponseEntity<>("Director added",HttpStatus.CREATED);
    }
    @GetMapping("get-movies-by-director-name/{name}")
    public ResponseEntity<Director> getDirectorByName(@PathVariable("name") String name){
        Director d=movieService.getDirectorByName(name);
        return new ResponseEntity<>(d,HttpStatus.FOUND);
    }

    @PutMapping("/add-movie-director-pair")
    public ResponseEntity<String> addMovieDirectorPair(@RequestParam("q1") String movieName,@RequestParam("q2") String directorName){
        movieService.addMovieDirectorPair(movieName,directorName);
        return new ResponseEntity<>("Movie Director pair added",HttpStatus.CREATED);
    }
    @GetMapping("/get-movies-by-director-name/{director}")
    public ResponseEntity<List<String>>  getMoviesByDirectorName(@PathVariable("director") String directorName){
        List<String>m=movieService.getMoviesByDirectorName(directorName);
        return new ResponseEntity<>(m,HttpStatus.FOUND);
    }

    @GetMapping("/get-all-movies")
    public ResponseEntity<List<String>> findAllMovies(){
        List<String>m=movieService.findAllMovies();
        return new ResponseEntity<>(m,HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/delete-director-by-name")
    public ResponseEntity<String> deleteDirectorByName(@RequestParam("q") String directorName){
        movieService.deleteDirectorByName(directorName);
        return new ResponseEntity<>("deleted director",HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/delete-all-directors")
    public ResponseEntity<String> deleteAllDirectors(){
        movieService.deleteAllDirectors();
        return new ResponseEntity<>("deleted all movies",HttpStatus.ACCEPTED);
    }




}
