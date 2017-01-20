package Comms;

import java.awt.event.KeyEvent;


public interface Comms 
{
    //PUERTO, BUFFERS
    public static final int portServidor = 2222;
    public static final String host = "localhost";
    public static final int MIDA_BUFFER = 1024;
    public static final int MIDA_BUFFER_INT = 4;
    //PROTOCOLO ENVÍO TECLAS
    public static final int UP = KeyEvent.VK_UP;
    public static final int DOWN = KeyEvent.VK_DOWN;
    public static final int STOP = 0;
    
}
