package com.alebit.ocsocks;

import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

public class Main {
    public Main() {
        try {
            new ProxyServer();
            URLClassLoader sockslibLoader = new URLClassLoader(new URL[]{new URL("https://raw.githubusercontent.com/AlecJY/OcSocks/master/libs/sockslib-1.0.0-SNAPSHOT.jar")}, this.getClass().getClassLoader());
            Class socksProxyServerFactory = Class.forName("sockslib.server.SocksProxyServerFactory", false, sockslibLoader);
            Method newNoAuthenticationServer = socksProxyServerFactory.getDeclaredMethod("newNoAuthenticationServer", int.class);
            Object instance = socksProxyServerFactory.newInstance();
            Object socksProxyServer = newNoAuthenticationServer.invoke(instance, 8080);
            Class socksProxyServerClass = Class.forName("sockslib.server.SocksProxyServer", true, sockslibLoader);
            Method start = socksProxyServerClass.getDeclaredMethod("start");
            start.invoke(socksProxyServer);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Main();
    }
}
