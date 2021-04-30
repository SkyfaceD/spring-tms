package org.skyfaced.tms.utils;

import java.util.UUID;

public final class UUIDUtils {
    @SuppressWarnings("ResultOfMethodCallIgnored")
    public static boolean isValidUUID(String id) {
        try {
            UUID.fromString(id);
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }

    public static UUID toUUID(String id) {
        return UUID.fromString(id);
    }
}
