package com.zhongsou.core.conf

import groovy.util.logging.Slf4j
import org.codehaus.groovy.runtime.ResourceGroovyMethods
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer
import org.springframework.stereotype.Component

@Slf4j
@Component
class SYPropertyPlaceholderConfigurer extends PropertyPlaceholderConfigurer {

    private static String configPathKey = "cfg.url"
    private static String defaultConfigPathKey = "config.test.properties"
    private static String eurekaInstanceIpAddress = "eureka.instance.ipAddress"

    @Override
    protected String resolvePlaceholder(String placeholder, Properties props) {
        if (properties && properties.containsKey(placeholder)) {
            return properties.get(placeholder)
        } else {
            return super.resolvePlaceholder(placeholder, props)
        }
    }

    volatile Properties properties = read(System.getProperty(configPathKey)) ?: read("file:${new File(defaultConfigPathKey).absolutePath}");

    static Properties read(String url) {
        if (!url) return null

        Properties p = new Properties()
        InputStream input = null;
        try {
            input = new URL(url).openStream();
            p.load(input)
        } catch (Throwable throwable) {
            log.error("load config from $url", throwable)
        } finally {
            ResourceGroovyMethods.closeQuietly(input)
        }

        return p.size() < 1 ? null : p
    }

    static toSys() {
        Properties properties = read(System.getProperty(configPathKey)) ?: read("file:${new File(defaultConfigPathKey).absolutePath}");
        ensuere(properties, eurekaInstanceIpAddress, guessMyIp())
        properties.each { k, v ->
            String ks = String.valueOf(k), vs = String.valueOf(v)
            if (!System.getProperty(ks))
                System.setProperty(ks, vs)
        }
    }

    static ensuere(Properties properties, String k, String v) {
        if (!properties.get(k) && v)
            properties.setProperty(k, v)
    }

    static String guessMyIp() {
        String ip = null
        NetworkInterface.getNetworkInterfaces().each { NetworkInterface nif ->
            nif.getInetAddresses().each { InetAddress addr ->
                String address = addr.getHostAddress()
                if (address && !address.startsWith('127.') && address ==~ /[0-9.]+/)
                    ip = address
            }
        }
        return ip
    }
}
