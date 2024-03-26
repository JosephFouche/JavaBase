import javax.swing.JFrame;

public class MarcoDelJuego extends JFrame {

	MarcoDelJuego(){
		this.add(new PanelDelJuego());
		this.setTitle("Vibora");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.pack();
		this.setVisible(true);
		this.setLocationRelativeTo(null);
	}
}
