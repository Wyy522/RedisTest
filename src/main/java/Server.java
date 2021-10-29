import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket =new ServerSocket(6380);
        while (true){
            Socket socket =serverSocket.accept();
            if(socket!=null&&socket.isBound()&&socket.isConnected()&&!socket.isClosed()){
                new Thread(new Listener(socket)).start();
            }
        }
    }
     private static class Listener implements Runnable{
        Socket socket =null;
        public Listener(Socket socket){
            this.socket=socket;
        }

         @Override
         public void run() {
            byte[] bytes =new byte[1024];
             try {
                 socket.getInputStream().read(bytes);
                 System.out.println("accpet data:-->\r\n"+new String(bytes));
                 socket.close();
             } catch (IOException e) {
                 e.printStackTrace();
             }


         }
     }
}
