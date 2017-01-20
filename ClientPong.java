package Client;


import Patron.ClientGUI;
import Patron.ModelTauler;

public class ClientPong
{
    public ClientPong() 
    {
    }
    /*Class Main del CLIENT. Inicialitza classes i engega la GUI. (Potser el bucle while hauria d'anar a dins de ControladorCom en un metode o algo) */
    public static void main(String[] args) throws InterruptedException, IOException 
    {

        ModelTauler modelClient= new ModelTauler();   //Model: info dels elements del joc.
        ClientGUI frame= new ClientGUI(modelClient);  //Vista - GUI del client.
        ControladorCom cCom = new ControladorCom(frame, modelClient); //Controlador de Vista i Model
        ClientPongStream stream= new ClientPongStream(cCom);
        ControladorInputUser control= new ControladorInputUser(stream);
        frame.crearMostrarGUI();
        stream.start();
        while (true) 
        {
            frame.repaint();
            frame.moverMundo();
            Thread.sleep(75);
        }
    }
}
