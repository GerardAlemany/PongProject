package Client;

import Comms.Stream;
import java.io.IOException;


import Comms.Comms;
import java.net.InetSocketAddress;

import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ClientPongStream  extends Thread implements Stream //extender Thread pa que? Porque tiene q escuchar el canal TODO EL PUTO RATO <--- mmm... no sé
{
    private SocketChannel sChan;
    private ControladorCom contCom;

	public ClientPongStream (ControladorCom contCom) throws IOException 
        {
            this.sChan = SocketChannel.open(new InetSocketAddress(Comms.portServidor));
            this.sChan.configureBlocking(false);
            this.contCom = contCom;
        }

        
    @Override
    public void send(int t) {
        try {
            //vamos a enviar ints, asociados a las arrowkeys: los ints tienen longitud = 4 bytes
            ByteBuffer buf = ByteBuffer.allocate(Comms.MIDA_BUFFER_INT);
            buf.putInt(t);
            //despues de un putInt hay que cascar un flip
            this.sChan.write(buf);
        } catch (IOException ex) {
            Logger.getLogger(ClientPongStream.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public void receive() 
    {
        try {
            ByteBuffer buf = ByteBuffer.allocate(Comms.MIDA_BUFFER);
            this.sChan.read(buf);
            buf.flip();
            this.contCom.processData(buf);
        } catch (IOException ex) {
            Logger.getLogger(ClientPongStream.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

   
