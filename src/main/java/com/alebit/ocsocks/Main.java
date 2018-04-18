package com.alebit.ocsocks;

import sockslib.server.SocksProxyServer;
import sockslib.server.SocksProxyServerFactory;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        SocksProxyServer socksProxyServer = SocksProxyServerFactory.newNoAuthenticationServer(8080);
        try {
            socksProxyServer.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
