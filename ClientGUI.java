package Patron;

import Client.ControladorInputUser;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.Observable;
import java.util.Observer;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import figures.Bola;
import figures.Raqueta;
import figures.Raqueta2;


public class ClientGUI extends JFrame implements Vista{

	private static final long serialVersionUID = 1L;
	private JPanel panel;
	private JLabel labelcontador;
	private JLabel fondo;
	private JLabel labelcontador2;
	//private ControladorInputUser control;
        private ModelTauler modelT;
	
	
	public ClientGUI(ModelTauler modelT)
        {
		//this.control = control
		super.setVisible(true);
                this.modelT = modelT;
                
		this.modelT.afegirObservador(this);
	}
        
        
        
	public  void crearMostrarGUI()
        {
            setTitle(" ---- Benvinguts a Ping Pong ---- ");
            setResizable(false);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setBounds(450, 100, 640, 450);
            panel = new JPanel();
            panel.setBorder(new EmptyBorder(5, 5, 5, 5));
            setContentPane(panel);
            panel.setLayout(null);
            // //////para poner fondo
            ((JPanel) getContentPane()).setOpaque(false);
            ImageIcon imagen = new ImageIcon(this.getClass().getResource("mesapinpong1.jpg"));
            // ///////////////////////

            labelcontador = new JLabel("0");
            labelcontador.setForeground(Color.WHITE);
            labelcontador.setFont(new Font("Monospaced", Font.BOLD, 17));
            labelcontador.setBounds(93, 0, 73, 18);
            panel.add(labelcontador);

            labelcontador2 = new JLabel("0");
            labelcontador2.setForeground(Color.WHITE);
            labelcontador2.setFont(new Font("Monospaced", Font.BOLD, 17));
            labelcontador2.setBounds(485, 2, 56, 16);
            panel.add(labelcontador2);
            fondo = new JLabel();
            fondo.setIcon(imagen);
            getLayeredPane().add(fondo, JLayeredPane.FRAME_CONTENT_LAYER);
            fondo.setBounds(0, 0, 640, 450);
            getContentPane().add(fondo, BorderLayout.CENTER);
            this.setSize(640, 484);
            this.setLocationRelativeTo(null);
            
            //esto de aquí abajo se tiene q revisar a gas, pq lo he cambiado sobre la marcha.
            //Lo mismo con toda línea que contenga "this.modelT" abajo

            this.modelT.bolita = new Bola(getWidth(), getHeight());
            this.modelT.raquetita1 = new Raqueta(getHeight());
            this.modelT.raquetita2 = new Raqueta2(getHeight());
            
            //esta instrucción debería ir fuera en el main y se le pasa el ControladorEntradaUser como argumento
    
            this.addKeyListener(control);

            // Sonido.FONDO.loop();
            // createBufferStrategy(2);
            // estrategia = this.getBufferStrategy();
        }
	

	public void paint(Graphics g) 
        {
            //revisar invocación sobre this.modelT
            super.paint(g);
            Graphics2D g2d = (Graphics2D) g;
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                            (RenderingHints.VALUE_ANTIALIAS_ON));
            g2d.setColor(Color.GREEN);
            this.modelT.bolita.pintarBola(g2d);
            g2d.setColor(Color.RED);
            this.modelT.raquetita1.pintarRaqueta1(g2d);
            g2d.setColor(Color.YELLOW);
            this.modelT.raquetita2.pintarRaqueta2(g2d);

	}

	public void moverMundo() 
        {
            this.modelT.bolita.moverBola();
           
            if (colision()) 
            {
                this.modelT.bolita.rebotaBola();
                this.modelT.golpes = this.modelT.golpes + 1;

                labelcontador.setText(String.valueOf(this.modelT.golpes / 2));
            }
            
            if (colision2()) 
            {
                this.modelT.bolita.rebotaBola();
                this.modelT.golpes2 = this.modelT.golpes2 + 1;

                labelcontador2.setText(String.valueOf(this.modelT.golpes2 / 2));
            }
            
            if (this.modelT.bolita.TocaFondo()) 
            {
                gameOver();
            }
	}
        
		public boolean colision() 
                {
                    return this.modelT.bolita.limiteBola().intersects(this.modelT.raquetita1.limiteRaqueta1());
		}

		public boolean colision2() 
                {
                    return this.modelT.bolita.limiteBola().intersects(this.modelT.raquetita2.limiteRaqueta2());
		}
		
	public void gameOver() 
        {
            if (this.modelT.golpes > this.modelT.golpes2) 
            {
                JOptionPane.showMessageDialog(this, "El jugador 1 gana","Game Over", JOptionPane.YES_NO_OPTION);
                System.exit(0);
            } 
            
            else 
            {
                if (this.modelT.golpes < this.modelT.golpes2) 
                {
                    JOptionPane.showMessageDialog(this, "El jugador 2 gana","Game Over", JOptionPane.YES_NO_OPTION);
                    System.exit(0);
                } 
                else 
                {
                    JOptionPane.showMessageDialog(this, "Empate", "Game Over",JOptionPane.YES_NO_OPTION);
                    System.exit(0);
                }
            }
	}
	@Override
	public void update(Observable arg0, Object arg1) 
        {
		this.update(this.modelT, arg1);
		
	}
}
