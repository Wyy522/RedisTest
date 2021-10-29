package protocol;


import java.io.IOException;
import java.io.OutputStream;

public class Protocol {
    private static final String DOLLER = "$";

    private static final String ALERSTIC = "*";

    private static final String CTLF = "\r\n";

    public static enum Comand {
        SET, GET, INCR, KEYS
    }

    public static void sendCommand(OutputStream outputStream, Protocol.Comand comand, byte[]... bytes) {
        StringBuilder sb = new StringBuilder();

        sb.append(ALERSTIC).append(1 + bytes.length).append(CTLF);
        sb.append(DOLLER).append(comand.name().length()).append(CTLF);
        sb.append(comand.name()).append(CTLF);

        for (byte[] arg : bytes) {
            sb.append(DOLLER).append(arg.length).append(CTLF);
            sb.append(new String(arg)).append(CTLF);
        }

        System.out.println("sendcammond-->\r\n" + sb.toString());

        try {
            outputStream.write(sb.toString().getBytes());
//          outputStream.write(sb.toString().getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
