package com.lonelyplanet.util.logging;

import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.CoreConstants;
import com.fasterxml.jackson.core.JsonGenerator;
import net.logstash.logback.composite.AbstractFieldJsonProvider;
import net.logstash.logback.composite.FieldNamesAware;
import net.logstash.logback.composite.JsonWritingUtils;

import java.io.IOException;

public class StackTraceHashProvider extends AbstractFieldJsonProvider<ILoggingEvent> {

    public static final String FIELD_HASH = "hash";

    private StackTraceHashConverter converter = new StackTraceHashConverter();

    public StackTraceHashProvider() {
        setFieldName(FIELD_HASH);
    }

    @Override
    public void start() {
        this.converter.start();
        super.start();
    }

    @Override
    public void stop() {
        this.converter.stop();
        super.stop();
    }

    @Override
    public void writeTo(JsonGenerator jsonGenerator, ILoggingEvent event) throws IOException {
        String hash = converter.convert(event);
        if (hash != null && !CoreConstants.EMPTY_STRING.equals(hash)) {
            JsonWritingUtils.writeStringField(jsonGenerator, getFieldName(), hash);
        }
    }
}
