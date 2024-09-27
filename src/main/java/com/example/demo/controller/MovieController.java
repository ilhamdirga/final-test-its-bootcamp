package com.example.demo.controller;

import com.example.demo.dto.MovieRequest;
import com.example.demo.dto.MovieResponse;
import com.example.demo.entity.Movie;
import com.example.demo.service.MovieService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/movie")
public class MovieController {

    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @PostMapping
    public String addMovie(@RequestBody MovieRequest request) {
        return movieService.save(request);
    }

//    @GetMapping(value = "/get/{id}")
//    public String getDataMovieById(@PathVariable Long id){
//        return movieService.get(id);
//    }

    @GetMapping(value = "/get/{id}")
    public ResponseEntity<?> getDataMovieById(@PathVariable Long id) {
        MovieResponse movieResponse = movieService.get(id);

        if (movieResponse != null) {
            return ResponseEntity.ok(movieResponse);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("movie with id " + id + " not found");
        }
    }

}

