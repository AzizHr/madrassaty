package com.example.madrassaty.services;

import com.example.madrassaty.exceptions.EmailAlreadyInUseException;
import com.example.madrassaty.exceptions.NotFoundException;

import java.io.IOException;

public interface AuthService<R1, R2, P1, P2> {

    R1 login(P1 p1);
    R2 register(P2 p2) throws NotFoundException, IOException, EmailAlreadyInUseException;

}
