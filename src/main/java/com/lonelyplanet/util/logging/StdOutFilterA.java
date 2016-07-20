package com.lonelyplanet.util.logging;

import ch.qos.logback.classic.Level;

import java.util.Arrays;
import java.util.HashSet;

public class StdOutFilterA extends Filter {
    private static HashSet<Level> allowed = new HashSet<>(Arrays.asList(Level.TRACE, Level.DEBUG, Level.INFO));

    @Override
    boolean isAllowed(Level level) {
        return allowed.contains(level);
    }
}
