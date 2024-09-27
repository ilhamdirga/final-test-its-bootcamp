package com.example.demo.service;

import com.example.demo.dto.MovieRequest;
import com.example.demo.dto.MovieResponse;


public interface MovieService {
    String save(MovieRequest movieRequest);

    MovieResponse get(Long id);



}
