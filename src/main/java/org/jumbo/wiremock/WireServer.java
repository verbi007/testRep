package org.jumbo.wiremock;

import com.github.tomakehurst.wiremock.WireMockServer;

public class WireServer {
    WireMockServer wireMockServer = new WireMockServer();

    public void start() {
        wireMockServer.start();
    }

    public void stop() {
        wireMockServer.stop();
    }
}
