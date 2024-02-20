package com.example.madrassaty.services;

import com.example.madrassaty.exceptions.NotFoundException;

import java.io.IOException;

public interface AuthService<T, S, R> {

    T login(S s);
    T register(R r) throws NotFoundException, IOException;

}
