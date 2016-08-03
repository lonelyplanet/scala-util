package com.lonelyplanet.util.logging;

import ch.qos.logback.classic.spi.ILoggingEvent;
import com.github.tkawachi.exhash.logback.ExHashConverter;

public class StackTraceHashConverter extends ExHashConverter {
    @Override
    public String convert(ILoggingEvent event) {
        return super.convert(event);
    }
}
