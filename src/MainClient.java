import java.net.*;
import java.io.*;

/**
 * Created by Vincent De Guille on 2017-03-09.
 */
public class MainClient {

    public static void main(String[] args)
    {
        int port = 50000;
        Socket socket;
        BufferedReader lecteurSocket;
        BufferedWriter ecritureSocket;

        try
        {
            InetAddress adresseServeur = InetAddress.getByName(args[0]);

            try
            {
                socket = new Socket(adresseServeur, port);

                InputStreamReader lecteurStream = new InputStreamReader(socket.getInputStream());
                OutputStreamWriter ecritureStream = new OutputStreamWriter(socket.getOutputStream());

                lecteurSocket = new BufferedReader(lecteurStream);
                ecritureSocket = new BufferedWriter(ecritureStream);

                InputStreamReader lecteurSysteme = new InputStreamReader(System.in);
                BufferedReader lecteurConsole = new BufferedReader(lecteurSysteme);

                String demandeConsole = "Entrez votre message a envoyer (Quitter pour fermer) : ";
                String messageSorti = null;

                while((messageSorti = lecteurConsole.readLine()) != null || (messageSorti = lecteurConsole.readLine()).equals(""))
                {
                    if(messageSorti.equalsIgnoreCase("quitter"))
                    {
                        socket.close();
                        break;
                    }

                    ecritureSocket.write(messageSorti + "\n");
                    ecritureSocket.flush();

                    String messageRecu = lecteurSocket.readLine();
                    System.out.println("Reponse serveur : " + messageRecu);
                    System.out.println(demandeConsole);
                }
            }
            catch(IOException e)
            {
                e.printStackTrace();
            }
        }
        catch(UnknownHostException e)
        {
            e.printStackTrace();
        }
    }
}
