package Client;


import Patron.ClientGUI;
import Patron.ModelTauler;

public class ClientPong
{
    public ClientPong() 
    {
    }
    
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
