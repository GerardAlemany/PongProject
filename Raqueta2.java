package figures;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;


public class Raqueta2 
{
    private int y, direccionY, alto, largo;
    private Color coloret;

    /**
     * Launch the application.
     */

    /**
     * Create the frame.
     */
    public Raqueta2(int alto) 
    {
        this.y = 0;
        this.direccionY = 1;
        this.largo = 70;
        this.coloret = Color.red;
        this.alto = alto;
    }

    public Raqueta2(int alto, Color coloret) 
    {
        this.alto = alto;
        this.coloret = coloret;

        this.y = 0;

        this.direccionY = 1;
        
    }

    public Raqueta2(int alto, Color coloret, int largo) 
    {
        this.alto = alto;
        this.coloret = coloret;
        this.largo = largo;
        this.y = 0;

        this.direccionY = 1;
    }
    
    //(x + direccionX > 0 && x + direccionX < ancho-largo 
    public void moverRaquetaabajo2() 
    {
        if (this.y -20 > -207 ) 
            this.y = this.y -50;
        
    }
    public void moverRaquetaarriba2() 
    {
        if (this.y + this.largo + 20 < this.alto-242) 
            y = y +50;
    }


    public void pintarRaqueta2(Graphics2D g) 
    {
        g.fillRoundRect(603,207-this.y, 20, this.largo,25,25);
    }


    public Rectangle limiteRaqueta2()
    {
        return new Rectangle(603,207-this.y, 20,this.largo);
    }
}





