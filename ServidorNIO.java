package Servidor;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

import Comms.*;
import Client.ControladorInputUser;
import Patron.ModelTauler;

public class ServidorNIO extends Thread {
	
    protected ServerSocketChannel ssc;
    protected Selector selector;
    protected ArrayList<SocketChannel> clientes; //doubting it hard

    protected ModelTauler modelTauler;

    public ServidorNIO() 
    {
        try {
            ssc = ServerSocketChannel.open();
            ssc.configureBlocking(false);
            ssc.socket().bind(new InetSocketAddress(Comms.portServidor));
            selector = Selector.open();
            clientes = new ArrayList<>();
            System.out.println("ServerSocketChannel obert!");

        } catch (IOException ex) {
                Logger.getLogger(ServidorNIO.class.getName()).log(Level.SEVERE,
                                null, ex);
        }
    }

    @Override
    public void run() {
        try {
            ssc.register(selector, SelectionKey.OP_ACCEPT);
        } catch (ClosedChannelException ex) {
            Logger.getLogger(ServidorNIO.class.getName()).log(Level.SEVERE,
                                null, ex);}
        while (true) 
        {
            try {
                selector.select();
            } catch (IOException ex) {
                    Logger.getLogger(ServidorNIO.class.getName()).log(Level.SEVERE, null, ex);
            }

            Set<SelectionKey> claves = selector.selectedKeys();
            Iterator<SelectionKey> it = claves.iterator();
            while (it.hasNext() ) 
            {
                SelectionKey clave = it.next();
                it.remove();

                if (clave.isAcceptable()) 
                {
                        accept(clave); 
                        System.out.println("Nou jugador online!");
                } 
                else if (clave.isReadable()) 
                {
                    try {
                        this.refreshData(clave);
                        System.out.println("S'han fet les accions!");
                    } catch (IOException ex) {
                        System.out.println("No s'ha pogut fer accions()");
                        Logger.getLogger(ServidorNIO.class.getName()).log(Level.SEVERE, null, ex);

                    }
                }
            }
        }
    }

    private void accept(SelectionKey clave) 
    {
        try {
            SocketChannel cliente = ((ServerSocketChannel) clave.channel()).accept();
            cliente.configureBlocking(false);
            cliente.register(selector, SelectionKey.OP_READ);
            //clientes.add(cliente);

        } catch (IOException ex) {
            System.out.println("No s'ha pogut acceptar connexio!");
            Logger.getLogger(ServidorNIO.class.getName()).log(Level.SEVERE,null, ex);
        }
    }

    public void refreshData (SelectionKey clave) throws IOException 
    { // CAMBIAR PQ EL SERVIDOR DONI LA INFO AL CLIENT

        System.out.println("Estic realitzant les accions");
        SocketChannel sc;
        sc = (SocketChannel) clave.channel();
        ByteBuffer buf = ByteBuffer.allocate(Comms.MIDA_BUFFER_INT);
        sc.read(buf);
        buf.flip();
        
        int move = buf.getInt();

        switch(move)
        {
            //Hay que encapsular las dos raquetas para poder hacerlo genérico y no definirse 2 
            case Comms.UP:
                    model.raquetita1.moverRaquetaarriba1();
                    break;
            case Comms.UP:
                    model.raquetita2.moverRaquetaarriba2();
                    break;
            case Comms.DOWN:
                    model.raquetita1.moverRaquetaabajo1();
                    break;

            case Comms.UP:
                    model.raquetita2.moverRaquetaabajo2();
                    break;
        }

            //espacio.flip();
            /*for (SocketChannel client : clientes) {
                    if (client != sc) {
                            while (espacio.hasRemaining()) {
                                    client.write(espacio);
                            }
                    }
            }*/
    }
}
