/**
 * Created by Vincent De Guille on 2017-03-02.
 */

import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class AppServer {

    public void server()
    {
        int port = 50000;

        ServerSocket serveur;

        try
        {
            serveur = new ServerSocket(port);

            Socket connexionSocket = serveur.accept();

            String data = "Hello from server";
            OutputStream out = connexionSocket.getOutputStream();
            out.write(data.getBytes());

            connexionSocket.close();
            serveur.close();

        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }



}
