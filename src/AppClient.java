/**
 * Created by Vincent De Guille on 2017-03-02.
 */

import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.ServerSocket;

public class AppClient {

    static int MAXLENGTH = 256;

    public void client(InetAddress adresse)
    {
        try
        {
            Socket clientSocket = new Socket(adresse, 50000);

            byte[] buff = new byte[MAXLENGTH];

            InputStream in = clientSocket.getInputStream();
            in.read(buff);

            clientSocket.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

}
