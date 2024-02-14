package com.example.madrassaty.services;

import com.example.madrassaty.exceptions.NotFoundException;

public interface AuthService<T, S, R> {

    T login(S s);
    T register(R r) throws NotFoundException;

}
