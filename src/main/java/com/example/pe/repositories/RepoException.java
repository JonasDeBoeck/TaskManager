package com.example.pe.repositories;

public class RepoException extends RuntimeException {

    public RepoException () {}

    public RepoException (String message) {
        super(message);
    }
}
