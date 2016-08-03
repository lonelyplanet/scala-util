package com.lonelyplanet.util.logging;

import ch.qos.logback.classic.spi.ILoggingEvent;

public class KibanaLinkConverter extends StackTraceHashConverter {

    private final static String kibanaFormat = "<a href=\"%s/api/v1/proxy/namespaces/kube-system/services/kibana-logging/?#/discover?_g=()&_a=(columns:!(kubernetes.pod_name,hash,message,stack_trace),index:'logstash-*',interval:auto,query:(query_string:(analyze_wildcard:!t,query:'hash:%%22%s%%22')),sort:!('@timestamp',desc))\" target=\"_blank\">Kibana Link</a>";
    private String host;

    @Override
    public void start() {
        super.start();
        host = System.getProperty("API_ROOT_HOST","");
    }

    @Override
    public String convert(ILoggingEvent event) {
        String hash = super.convert(event);
        return createKibanaLink(hash);
    }

    private String createKibanaLink(String hash) {
        return String.format(kibanaFormat, host, hash);
    }

}
