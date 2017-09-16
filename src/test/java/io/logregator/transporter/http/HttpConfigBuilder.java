package io.logregator.transporter.http;

import org.apache.http.client.HttpClient;

public final class HttpConfigBuilder {
    private HttpClient httpClient;
    private String url;

    private HttpConfigBuilder() {
    }

    public static HttpConfigBuilder aHttpConfig() {
        return new HttpConfigBuilder();
    }

    public HttpConfigBuilder withHttpClient(HttpClient httpClient) {
        this.httpClient = httpClient;
        return this;
    }

    public HttpConfigBuilder withUrl(String url) {
        this.url = url;
        return this;
    }

    public HttpTransporterConfig build() {
        HttpTransporterConfig httpTransporterConfig = new HttpTransporterConfig();
        httpTransporterConfig.setHttpClient(httpClient);
        httpTransporterConfig.setUrl(url);
        return httpTransporterConfig;
    }
}
