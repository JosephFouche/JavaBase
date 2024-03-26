import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;

public class PanelDelJuego extends JPanel implements ActionListener {
    static final int SCREEN_WIDTH = 600;
    static final int SCREEN_HEIGHT = 600;
    static final int UNIT_SIZE = 25;
    static final int GAME_UNITS = (SCREEN_WIDTH * SCREEN_HEIGHT) / UNIT_SIZE;
    static final int DELAY = 75;
    final int x[] = new int[GAME_UNITS];
    final int y[] = new int[GAME_UNITS];
    int bodyParts = 6;
    int naranjasComidas;
    int naraX;
    int naraY;
    char direction = 'R';
    boolean running = false;
    Timer timer;
    Random random;

    PanelDelJuego() {
        random = new Random();
        this.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
        this.setBackground(Color.black);
        this.setFocusable(true);
        this.addKeyListener(new MyKeyAdapter());
        empezarJuego();
    }

    public void empezarJuego() {
        nuevaNaranja();
        running = true;
        timer = new Timer(DELAY, this);
        timer.start();
    }

    public void nuevaNaranja() {
        naraX = random.nextInt((int)(SCREEN_WIDTH/UNIT_SIZE)) * UNIT_SIZE;
        naraY = random.nextInt((int)(SCREEN_HEIGHT/UNIT_SIZE)) * UNIT_SIZE;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        dibujar(g);
    }

    public void dibujar(Graphics g) {
    	if(running) {
    	/*
	        for (int i = 0; i < SCREEN_WIDTH / UNIT_SIZE; i++) {
	            g.drawLine(i * UNIT_SIZE, 0, i * UNIT_SIZE, SCREEN_HEIGHT);
	            g.drawLine(0, i * UNIT_SIZE, SCREEN_WIDTH, i * UNIT_SIZE);
	        }*/
	        g.setColor(Color.ORANGE);
	        g.fillOval(naraX, naraY, UNIT_SIZE, UNIT_SIZE);
	        
	        for(int i = 0;i<bodyParts;i++) {
	        	if(i==0) {
	        		g.setColor(Color.blue);
	        		g.fillRect(x[i],y[i],UNIT_SIZE,UNIT_SIZE);
	        		
	        	}
	        	else {
	        		g.setColor(new Color(45,180,0));
	        		g.fillRect(x[i],y[i],UNIT_SIZE,UNIT_SIZE);
	        		
	        	}
	        }
	        //mostrar puntuacion
	    	g.setColor(Color.red);
	    	g.setFont(new Font("Times New Roman",Font.BOLD,30));
	    	FontMetrics metrics = getFontMetrics(g.getFont());
	    	g.drawString("PUNTUACION: "+naranjasComidas,(SCREEN_WIDTH-metrics.stringWidth("PUNTUACION: "+naranjasComidas))/2, g.getFont().getSize());
    	}else {
    		juegoTerminado(g);
    	}
    }

    public void mover() {
    	for(int i= bodyParts;i>0;i--) {//continuar mientras i sea mayor que 0
    		//shifting the body parts of our snake around
    		x[i]=x[i-1];
    		y[i]=y[i-1];
    		
    	}
    	switch(direction) {
    	case 'U':
    		y[0]=y[0]-UNIT_SIZE;
    		break;
    	case 'D':
    		y[0]=y[0]+UNIT_SIZE;
    		break;
    	case 'L':
    		x[0]=x[0]-UNIT_SIZE;
    		break;
    	case 'R':
    		x[0]=x[0]+UNIT_SIZE;
    		break;
    	
    	}
    }

    public void revisarNaranja() {
    	if((x[0]==naraX)&&(y[0]==naraY)) {
    		bodyParts++;
    		naranjasComidas++;
    		nuevaNaranja();
    	}
    }

    public void revisarChoques() {
    	//revisa si cabeza choca con cuerpo
    	for(int i = bodyParts; i>0;i--) {
    		if((x[0]==x[i])&&(y[0]==y[i])) {
    			running  = false;
    		}
    	}
    	//revisa si cabeza choca con borde izquierdo
    	if(x[0]<0) {
    		running  = false;
    		
    	}
    	//revisa si cabeza choca con borde derecho
    	if(x[0]>SCREEN_WIDTH) {
    		running  = false;
    		
    	}
    	//revisa si cabeza choca con borde de arriba
    	if(y[0]<0) {
    		running = false;
    	}
    	//revisa si cabeza choca con borde de abajo
    	if(y[0]>SCREEN_HEIGHT) {
    		running = false;
    	}
    	if(!running) {
    		timer.stop();
    	}
    }

    public void juegoTerminado(Graphics g) {
    	//Mostrar tablero 
    	g.setColor(Color.red);
    	g.setFont(new Font("Times New Roman",Font.BOLD,30));
    	FontMetrics metrics1 = getFontMetrics(g.getFont());
    	g.drawString("PUNTUACION: "+naranjasComidas,(SCREEN_WIDTH-metrics1.stringWidth("PUNTUACION: "+naranjasComidas))/2, g.getFont().getSize());
    	//Texto juego terminado
    	g.setColor(Color.red);
    	g.setFont(new Font("Times New Roman",Font.BOLD,75));
    	FontMetrics metrics2 = getFontMetrics(g.getFont());
    	g.drawString("Juego Terminado",(SCREEN_WIDTH-metrics2.stringWidth("Juego Terminado"))/2, SCREEN_HEIGHT/2);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
    	if(running) {
    		mover();
    		revisarNaranja();
    		revisarChoques();
    	}
    	repaint();
    }

    public class MyKeyAdapter extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
        	switch(e.getKeyCode()) {
        	case KeyEvent.VK_LEFT:
        		if(direction != 'R') {
        			direction = 'L';
        		}
        		break;
        	case KeyEvent.VK_RIGHT:
        		if(direction != 'L') {
        			direction = 'R';
        		}
        		break;	
        	case KeyEvent.VK_UP:
        		if(direction != 'D') {
        			direction = 'U';
        		}
        		break;
        	case KeyEvent.VK_DOWN:
        		if(direction != 'U') {
        			direction = 'D';
        		}
        		break;
        	}
        }
    }
}