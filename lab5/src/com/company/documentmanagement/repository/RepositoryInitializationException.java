package com.company.documentmanagement.repository;

public class RepositoryInitializationException extends Exception {

    public RepositoryInitializationException(Exception e){
        super("Invalid repository.",e);
    }

}
