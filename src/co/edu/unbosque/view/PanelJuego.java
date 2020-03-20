package co.edu.unbosque.view;

import javax.swing.*;
import java.awt.*;

public class PanelJuego extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private PanelTablero panelTablero = new PanelTablero();
	private PanelBoton panelBoton = new PanelBoton();

	public PanelJuego() {
		cargar();
		addComponentes();
	}
	
	public void cargar() {
		setLayout(new BorderLayout());
		setOpaque(false);
		Color color = new Color(255, 255, 255);
		color.getTransparency();
		setBackground(color);
	}
	
	public void addComponentes() {
		add(panelTablero, BorderLayout.CENTER);
		add(panelBoton, BorderLayout.CENTER);
	}

	public PanelTablero getPanelTablero() {
		return panelTablero;
	}

	public PanelBoton getPanelBoton() {
		return panelBoton;
	}
	
	

}
