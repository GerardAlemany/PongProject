package Client;


import Patron.ClientGUI;
import Patron.ModelTauler;

public class ClientPong
{
    public ClientPong() 
    {
        //constructor pending
    }
    
    public static void main(String[] args) throws InterruptedException 
    {

        ModelTauler model= new ModelTauler();
        ControladorCom cCom = new ControladorCom
        ClientPongStream cpg= new 
        ControladorInputUser control= new ControladorInputUser(model);
        ClientGUI frame= new ClientGUI(control);
        ClientPongStream stream= new ClientPongStream();
        //stream.start(); No sé si realmente hay que hacer que sea un Thread
        frame.crearMostrarGUI();
        
        while (true) 
        {
            frame.repaint();
            frame.moverMundo();
            Thread.sleep(75);
        }
    }
}
