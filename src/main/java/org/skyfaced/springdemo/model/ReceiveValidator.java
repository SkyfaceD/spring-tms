package org.skyfaced.springdemo.model;

import org.skyfaced.springdemo.utils.exceptions.ErrorException;

public interface ReceiveValidator {
    void validate() throws ErrorException;
}
