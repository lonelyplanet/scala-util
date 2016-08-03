package com.lonelyplanet.util.logging;

import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.CoreConstants;

public class KibanaLinkConverter extends StackTraceHashConverter {

    private final static String kibanaFormat = "<a href=\"%s/api/v1/proxy/namespaces/kube-system/services/kibana-logging/?#/discover?_g=()&_a=(columns:!(kubernetes.pod_name,hash,message,stack_trace),index:'logstash-*',interval:now-7d,query:(query_string:(analyze_wildcard:!t,query:'hash:%%22%s%%22')),sort:!('@timestamp',desc))\" target=\"_blank\">Kibana Link</a>";
    private String apiHost;

    @Override
    public void start() {
        super.start();
    }

    @Override
    public String convert(ILoggingEvent event) {
        String hash = super.convert(event);

        if (!hash.equals(CoreConstants.EMPTY_STRING)) {
            return createKibanaLink(hash);
        } else {
            return CoreConstants.EMPTY_STRING;
        }
    }

    public void setApiHost(String apiHost) {
        this.apiHost = apiHost;
    }

    public String getApiHost() {
        return this.apiHost;
    }

    private String createKibanaLink(String hash) {
        return String.format(kibanaFormat, apiHost, hash);
    }

}
