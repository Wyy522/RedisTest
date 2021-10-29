package client;


import connection.Connection;
import protocol.Protocol;

import java.io.IOException;

public class Client {
    private Connection connection;

    public Client(String host,int port) {
        connection =new Connection(host,port);
    }

    public String set(String key,String value) throws IOException {
        connection.sendCommand(Protocol.Comand.SET, key.getBytes(),value.getBytes());
    return  connection.replyCodeStirng();
    }

    public String get(String key) throws IOException {
        connection.sendCommand(Protocol.Comand.GET, key.getBytes());
        return  connection.replyCodeStirng();
    }
    public String incr(String key) throws IOException {
        connection.sendCommand(Protocol.Comand.INCR, key.getBytes());
        return  connection.replyCodeStirng();
    }
}
