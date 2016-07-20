package com.lonelyplanet.util.logging;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.spi.LoggingEvent;
import ch.qos.logback.core.spi.FilterReply;

abstract class Filter extends ch.qos.logback.core.filter.AbstractMatcherFilter {
    abstract boolean isAllowed(Level level);

    @Override
    public FilterReply decide(Object event) {
        if(!isStarted()){
            return FilterReply.NEUTRAL;
        } else {
            LoggingEvent e = (LoggingEvent) event;
            if(isAllowed(e.getLevel())) {
                return FilterReply.NEUTRAL;
            } else {
                return FilterReply.DENY;
            }
        }
    }
}
