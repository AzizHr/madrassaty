package com.example.madrassaty.services;

import com.example.madrassaty.exceptions.NotFoundException;

public interface GlobalService<T, S> {

    T save(S s) throws NotFoundException;
    T update(S s) throws NotFoundException;
    void delete(long id) throws NotFoundException;
    T findById(long id) throws NotFoundException;

}
