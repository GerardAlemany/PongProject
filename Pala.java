/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package figures;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

/**
 *
 * @author Idealibi
 */
public class Pala {
    
    protected int y, direccionY, alto, largo, id;
    protected  Color coloret;

    /**
     * Launch the application.
     * Create the frame.
     */
    public Pala(int alto, int id) 
    {
        this.id = id;
        this.y = 0;
        this.direccionY = 1;
        this.largo = 70;
        this.coloret = Color.red;
        this.alto = alto;

    }

    public Pala(int alto, Color coloret, int id) 
    {
        this.id = id;
        this.alto = alto;
        this.coloret = coloret;

        this.y = 0;

        this.direccionY = 1;
    }

    public Pala(int alto, Color coloret, int largo, int id) 
    {
        this.id = id;
        this.alto = alto;
        this.coloret = coloret;
        this.largo = largo;
        this.y = 0;

        this.direccionY = 1;
    }
    
//(x + direccionX > 0 && x + direccionX < ancho-largo 
    public void moverPalaAbajo() 
    {
        if (this.y -20 > -207)  //(484/2-largo)=207  /// ojo largo=70
            this.y = this.y -50;
    }

    public void moverPalaArriba() 
    {    
        if (this.y + this.largo + 20 < this.alto - 242 ) //(484/2)=242
            this.y = this.y +50;
    }

    public void pintarPala(Graphics2D g) 
    {
        if (id==1)g.fillRoundRect(15, 207-this.y, 20,this.largo,25,25);
        
        if (id==2)g.fillRoundRect(603,207-this.y, 20, this.largo,25,25);
    }

    public Rectangle limitePala()
    {
        if (id==1)return new Rectangle(15,207-this.y,20,this.largo);
            
        if (id==2)return new Rectangle(603,207-this.y, 20,this.largo); 
            
        return(null);
        }
    }
