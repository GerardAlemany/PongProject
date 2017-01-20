package Patron;

import Client.ControladorInputUser;
import javax.swing.JOptionPane;

import figures.Bola;
import figures.Raqueta;
import figures.Raqueta2;


public class ModelTauler extends ModelAbstracte{
    
    public Raqueta r1;
    public Raqueta2 r2;
    protected Bola bolita;
    protected int golpes, golpes2;
    protected int punt1, punt2;


    public ModelTauler(){
	this.golpes = 0;
	this.golpes2 = 0;
	this.bolita= new Bola(10,500);
	this.r1= new Raqueta(20);
	this.r2= new Raqueta2(20);	
    }
    
    public void actualitzar(){
        
    }
}

