package co.edu.unbosque.controller;

import javax.swing.JOptionPane;

import co.edu.unbosque.model.Canino;
import co.edu.unbosque.model.Felino;
import co.edu.unbosque.model.Roedor;
import co.edu.unbosque.view.View;

public class Controller {


	public void mostrarDatos() {

		View vis = new View();

		vis.mostrarMenu();

		int opci;
		boolean salir = false;

		opci = vis.leerObccion();

		switch (opci) {

		case 1:

			Canino can = new Canino();
			can.alimentar();

			break;

		case 2:
			
			Felino fe = new Felino();
			fe.alimentar();

			break;

		case 3:
			
			Roedor ro = new Roedor();
			ro.alimentar();

			break;
		case 4:

			salir = true;
			JOptionPane.showMessageDialog(null, "Hasta Luego");
			break;

		default:

			JOptionPane.showMessageDialog(null, "Opcion Incorrecta");
			break;

		}

	}

}
