/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Client;

import Patron.ClientGUI;
import Patron.ModelTauler;
import java.nio.ByteBuffer;


/**
 *
 * @author alejandro
 */
public class ControladorCom 
{
    private ClientGUI cgui; //no sé si es necesario en realidad
    private ModelTauler modelTauler;
    
    
    public ControladorCom (ClientGUI c, ModelTauler mT)
    {
        this.cgui = c;
        this.modelTauler = mT;
    }
    
    /***
     * ACHTUNG!.
     * 
     * Este controlador resta a la espera de recibir la información proveniente del ServerNIO a través de ClientPongStream.
     * Para tal efecto, guarda una relación con la GUI (Vista) (yo creo que con que se relacione con el modelo es suficiente) y los datos relevantes del tablero (ModelTauler)
     */
    
    //cuando recibe la mandanga, se lo casca al modelo fisnamente
    
    public void processData(ByteBuffer buf)
    {
        /***
         * Aquí va a llegar toda la info actualizada pegada en un ByteBuffer.
         * Eso es osición de raquetas, bola, puntuación, etc.
         * En una primera aproximación (no sé cómo picarlo aún), cuando nos llega el buffer debemos separar los bytes de cada concepto y 
         * convertirlo en el objeto o tipo que toque. Si no, supongo que tendríamos que enviar más de un paquete pero puede dar por saco.
         ***/
    }
}
