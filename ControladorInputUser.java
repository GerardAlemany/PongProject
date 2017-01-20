package Client;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;



public class ControladorInputUser implements KeyListener 
{
    
	private ClientPongStream stream;
	
        
	public ControladorInputUser(ClientPongStream stream) 
        {
            this.stream = stream;
	}
        
        /***
         * ACHTUNG!.
         * Solo hay que definir dos keyEvent: key_UP y key_DOWN. 
         * Ambos jugadores se mueven igual, pq juegan en 2 terminales distintas.
         * La cosa es que ambos inputs llegan por separado, así que 
         * 
         * 1) Basta con definir un tipo de raqueta y crear 2 instancias:
         *      - la primera se posiciona en una esquina y la segunda en otra (lo pasams por parametro)
         * 2) Deberíamos hacer que este controlador cambie directamente la vista del usuario? 
         *          (Marcel dijo que NO: todo se envía al server y a partir de ahí se actualizan los cambios)
         *      - a) Podemos hacer que se envíe directamente al servidor y q este actualice los cambios en el modelo
         *      - b) Podemos asociar el modelo al controlador, y que cuando se presiona una tecla cambiemos el modelo 
         *          aparte de enviarlo al server. Por lo tanto el movimiento de la raqueta es inmediato
         * @param e 
         */

	@Override
	public void keyPressed(KeyEvent e) 
        {
            int code = e.getKeyCode();
            this.stream.send(code);
	}

	@Override
	public void keyReleased(KeyEvent es) 
        {
            //podemos hacer que si suelta la tecla se quede quieto, he creado un campo en Comms por si acaso
            //this.stream.send(Comms.STOP);
            //actualizar modelo (raqueta quieta -> no movimiento)
	}

	@Override
	public void keyTyped(KeyEvent arg0) 
        {
            // TODO Auto-generated method stub
	}

}
