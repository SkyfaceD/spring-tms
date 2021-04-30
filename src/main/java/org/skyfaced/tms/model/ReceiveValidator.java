package org.skyfaced.tms.model;

import org.skyfaced.tms.utils.exceptions.ErrorException;

public interface ReceiveValidator {
    void validate() throws ErrorException;
}
