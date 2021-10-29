package connection;


import protocol.Protocol;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Connection {
    private  String host;
    private  int port;

    private Socket socket;
    private InputStream inputStream;
    private OutputStream outputStream;

    public Connection(String host, int port) {
        this.host = host;
        this.port = port;
    }

    private void connect() throws IOException {
        if (inConnected()) {
            socket = new Socket(this.host, this.port);
            this.inputStream = socket.getInputStream();
            this.outputStream = socket.getOutputStream();
        }
    }

    private  boolean inConnected() {
        return socket != null && socket.isBound() && socket.isConnected() && !socket.isClosed();
    }

    public void sendCommand(Protocol.Comand comand, byte[]...bytes) throws IOException {
        Protocol.sendCommand(this.outputStream,comand,bytes);

    }

    public String replyCodeStirng(){
        byte[] bytes =new byte[1024];
        try {
            this.inputStream.read(bytes);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new String(bytes);
    }

}
