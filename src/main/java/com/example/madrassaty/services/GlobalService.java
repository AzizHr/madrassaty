package com.example.madrassaty.services;

import com.example.madrassaty.exceptions.NotFoundException;

import java.util.UUID;

public interface GlobalService<T, S> {

    T save(S s) throws NotFoundException;
    T update(S s) throws NotFoundException;
    void delete(UUID id) throws NotFoundException;
    T findById(UUID id) throws NotFoundException;

}
