/**
 * Created by Vincent De Guille on 2017-03-02.
 */

import java.io.*;
import java.net.*;

public class AppClient {

    static int MAXLENGTH = 256;

    public void client(InetAddress adresse)
    {
        try
        {
            Socket clientSocket = new Socket(adresse, 50000);

            byte[] buff = new byte[MAXLENGTH];

            InputStream serverInput = clientSocket.getInputStream();
            serverInput.read(buff);

            PrintStream output = new PrintStream(clientSocket.getOutputStream());

            clientSocket.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

}
