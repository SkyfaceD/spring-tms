package org.skyfaced.springdemo.model;

public interface Updatable {
    <T> T update(Object object) throws Exception;
}
