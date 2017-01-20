package figures;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Raqueta 
{
    protected int y, direccionY, alto, largo;
    protected  Color coloret;

    /**
     * Launch the application.
     * Create the frame.
     */
    public Raqueta(int alto) 
    {

        this.y = 0;
        this.direccionY = 1;
        this.largo = 70;
        this.coloret = Color.red;
        this.alto = alto;

    }

    public Raqueta(int alto, Color coloret) 
    {
        this.alto = alto;
        this.coloret = coloret;

        this.y = 0;

        this.direccionY = 1;
    }

    public Raqueta(int alto, Color coloret, int largo) 
    {
        this.alto = alto;
        this.coloret = coloret;
        this.largo = largo;
        this.y = 0;

        this.direccionY = 1;
    }

    //(x + direccionX > 0 && x + direccionX < ancho-largo 
    public void moverRaquetaabajo1() 
    {
        if (this.y -20 > -207)  //(484/2-largo)=207  /// ojo largo=70
            this.y = this.y -50;
    }

    public void moverRaquetaarriba1() 
    {    
        if (this.y + this.largo + 20 < this.alto - 242 ) //(484/2)=242
            this.y = this.y +50;
    }

    public void pintarRaqueta1(Graphics2D g) 
    {

        g.fillRoundRect(15, 207-y, 20,largo,25,25);

    }

    public Rectangle limiteRaqueta1()
    {
        return new Rectangle(15,207-y,20,largo);

    }

	
}

