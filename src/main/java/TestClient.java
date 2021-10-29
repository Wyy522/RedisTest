
import client.Client;

import java.io.IOException;

public class TestClient {
    public static void main(String[] args) throws IOException {
//        Jedis jedis =new Jedis("localhost",6380);
//        jedis.set("2019","wyy");
        Client client =new Client("127.0.0.1",6379);
        System.out.println(client.set("2019","wyy"));
    }
}
