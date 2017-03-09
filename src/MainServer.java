import java.net.*;
import java.io.*;

/**
 * Created by Vincent De Guille on 2017-03-09.
 */

public class MainServer {

    public static void main(String[] args)
    {
        int port = 50000;
        ServerSocket serveur;

        try
        {
            serveur = new ServerSocket(port);
            System.out.println("Le serveur est demarre a : " + serveur.getLocalSocketAddress());

            //Boucle qui attend une connexion tant et aussi longtemps
            //que le serveur est démarré.
            while(true)
            {
                System.out.println("En attente d'une connexion.");
                Socket socketClient = serveur.accept();
                System.out.println("Connexion etablie!");

                AppServer server = new AppServer();

                //Inspire de : http://docs.oracle.com/javase/tutorial/java/javaOO/lambdaexpressions.html#approach5
                //et de http://stackoverflow.com/questions/15146052/what-does-the-arrow-operator-do-in-java
                //et de https://docs.oracle.com/javase/7/docs/api/java/lang/Runnable.html
                Runnable executable = () -> server.receptionRequeteClient(socketClient);

                //Demarre un nouveau thread a chaque connexion
                new Thread(executable).start();
            }
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }
}
