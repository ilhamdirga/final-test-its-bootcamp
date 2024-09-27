package com.example.demo.service.impl;

import com.example.demo.dto.MovieRequest;
import com.example.demo.dto.MovieResponse;
import com.example.demo.entity.Movie;
import com.example.demo.repository.MovieRepository;
import com.example.demo.service.MovieService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MovieServiceImpl implements MovieService {
    private final MovieRepository movieRepository;

    public MovieServiceImpl(MovieRepository movieRepository){
        this.movieRepository = movieRepository;
    }

    @Override
    public String save(MovieRequest request){
        saveToDb(request);
        return "Success";
    }

    @Override
    public MovieResponse get(Long id){
        Optional<Movie> movieOptional = movieRepository.findById(id);

        if(movieOptional.isPresent()){
            Movie movie = movieOptional.get();
            MovieResponse response = new MovieResponse();
            response.setId(movie.getId());
            response.setTitle(movie.getTitle());
            response.setGenre(movie.getGenre());
            response.setDuration(movie.getDuration());
            response.setDirector(movie.getDirector());
            response.setRating(movie.getRating());
            response.setCreatedAt(movie.getCreatedAt());
            response.setModifiedAt(movie.getModifiedAt());

            return response;
        } else {
            return null;
        }
    }

//    @Override
//    public String get(Long id) {
//        Optional<Movie> movie = movieRepository.findById(id);
//
//        if(movie.isPresent()){
//            return "Success";
//        } else {
//            return "Data not found";
//        }
//    }


    private void saveToDb(MovieRequest request){
        Movie movie = new Movie();
        movie.setTitle(request.getTitle());
        movie.setGenre(request.getGenre());
        movie.setDuration(request.getDuration());
        movie.setDirector(request.getDirector());
        movie.setRating(request.getRating());
        movieRepository.save(movie);
    }

}
