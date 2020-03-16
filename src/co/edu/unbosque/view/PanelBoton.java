package co.edu.unbosque.view;
import javax.swing.*;
import java.awt.*;
/**
 * @author Ricardo Sanchez
 *
 */
public class PanelBoton extends JPanel {
    private static final long serialVersionUID = 1L;
	private JButton juego = new JButton("Juego");
	public final String OPERAR = "Operar";
	/**
	 * @author  Ricardo Sanchez
	 */
	public PanelBoton() {
		try {
			cargar();
			addComponentes();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * @author Ricardo Sanchez
	 * @throws Exception
	 */
	public void cargar() throws Exception {
		
		setLayout(null);
		setBounds(700,500 , 100, 100);
		setBackground(SystemColor.activeCaption);
		juego.setBounds(350,500 , 100, 50);
		juego.setBackground(new Color(240,240,240));
		juego.setForeground(Color.black);
		juego.setActionCommand(OPERAR);
		
	}
	
	/**
	 * @author Ricardo Sanchez
	 */
	public void addComponentes() {
		add(juego);
	}

	/**
	 * @author Ricardo Sanchez
	 * @return
	 */
	public JButton getJuego() {
		return juego;
	}


}
