/**
 * Created by Vincent De Guille on 2017-03-02.
 */

import java.io.*;
import java.net.*;

public class AppServer {

    public void receptionRequeteClient(Socket socket)
    {
        try
        {
            BufferedReader lecteurSocket;
            BufferedWriter ecritureSocket;
            InputStreamReader lecteurStream = new InputStreamReader(socket.getInputStream());
            OutputStreamWriter ecritureStream = new OutputStreamWriter(socket.getOutputStream());

            lecteurSocket = new BufferedReader(lecteurStream);
            ecritureSocket = new BufferedWriter(ecritureStream);

            String messageRecu = null;
            while((messageRecu = lecteurSocket.readLine()) != null)
            {
                System.out.println("Message recu : " + messageRecu + "; Adresse IP du client : " + socket.getInetAddress() + "; Port du client" + socket.getLocalPort());
                String messageSorti = messageRecu.toUpperCase();
                ecritureSocket.write(messageSorti + "\\n");
                ecritureSocket.flush();
            }

            socket.close();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }

}
