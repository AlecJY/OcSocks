package com.alebit.ocsocks;

import fucksocks.server.GenericSocksProxyServer;
import fucksocks.server.SocksProxyServer;
import fucksocks.server.SocksProxyServerFactory;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        SocksProxyServer socksProxyServer = SocksProxyServerFactory.newNoAuthenticaionServer();
        try {
            socksProxyServer.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
