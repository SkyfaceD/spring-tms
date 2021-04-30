package org.skyfaced.tms.model;

public interface Updatable {
    <T> T update(Object object) throws Exception;
}
