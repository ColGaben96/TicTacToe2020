package co.edu.unbosque.view;
import javax.swing.*;
import java.awt.*;
import java.io.File;
/**
 *  @author Ricardo Sanchez
 *
 */
public class PanelTablero extends JPanel {
   
	private static final long serialVersionUID = 1L;
	private JTextField pos11 = new JTextField();
    private JTextField pos12 = new JTextField(); 
    private JTextField pos13 = new JTextField(); 
    private JTextField pos21 = new JTextField(); 
    private JTextField pos22 = new JTextField(); 
    private JTextField pos23 = new JTextField(); 
    private JTextField pos31 = new JTextField(); 
    private JTextField pos32 = new JTextField(); 
    private JTextField pos33 = new JTextField();
    //private Icon icono;
   // private ImageIcon imagen;
    
    /**
     * @author Ricardo Sanchez
     */
    PanelTablero() {
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
    	setBounds(0,0,800,500);
    	
    	Font bradley = Font.createFont(Font.TRUETYPE_FONT, new File("./docs/Lib/BRADHITC.TTF")).deriveFont(Font.BOLD, 100f);
    	
		pos11.setBounds(64, 27, 162, 111);
		pos11.setForeground(Color.black);
		pos11.setBackground(Color.white);
		pos11.setHorizontalAlignment(JTextField.CENTER);
		pos11.setFont(bradley);
		
		pos12.setBounds(314, 27, 162, 111);
		pos12.setForeground(Color.black);
		pos12.setBackground(Color.white);
		pos12.setHorizontalAlignment(JTextField.CENTER);
		pos12.setFont(bradley);
		
		pos13.setBounds(554, 27, 162, 111);
		pos13.setForeground(Color.black);
		pos13.setBackground(Color.white);
		pos13.setHorizontalAlignment(JTextField.CENTER);
		pos13.setFont(bradley);
		
		pos21.setBounds(64, 185, 162, 111);
		pos21.setForeground(Color.black);
		pos21.setBackground(Color.white);
		pos21.setHorizontalAlignment(JTextField.CENTER);
		pos21.setFont(bradley);
		
		pos22.setBounds(314, 185, 162, 111);
		pos22.setForeground(Color.black);
		pos22.setBackground(Color.white);
		pos22.setHorizontalAlignment(JTextField.CENTER);
		pos22.setFont(bradley);
		
		pos23.setBounds(554, 185, 162, 111);
		pos23.setForeground(Color.black);
		pos23.setBackground(Color.white);
		pos23.setHorizontalAlignment(JTextField.CENTER);
		pos23.setFont(bradley);
		
		pos31.setBounds(64, 343, 162, 111);
		pos31.setForeground(Color.black);
		pos31.setBackground(Color.white);
		pos31.setHorizontalAlignment(JTextField.CENTER);
		pos31.setFont(bradley);
		
		pos32.setBounds(314, 343, 162, 111);
		pos32.setForeground(Color.black);
		pos32.setBackground(Color.white);
		pos32.setHorizontalAlignment(JTextField.CENTER);
		pos32.setFont(bradley);
		
		pos33.setBounds(554, 343, 162, 111);
		pos33.setForeground(Color.black);
		pos33.setBackground(Color.white);
		pos33.setHorizontalAlignment(JTextField.CENTER);
		pos33.setFont(bradley);
		
		//imagen = new ImageIcon(getClass().getResource(new File("./docs/Lib/cuadriculado.jpg")));
		//icono = new ImageIcon(imagen.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));
	}
    /**
     * @author Ricardo Sanchez
     */
    public void addComponentes() {
		add(pos11);
		add(pos12);
		add(pos13);
		add(pos21);
		add(pos22);
		add(pos23);
		add(pos31);
		add(pos32);
		add(pos33);
		
		
	}
	
	/**
	 * @author Ricardo Sanchez
	 * @return
	 */
	public JTextField getPos12() {
		
		return pos12;
	}
	public void setPos12(JTextField pos12) {
		this.pos12 = pos12;
	}
	public JTextField getPos13() {
		return pos13;
	}
	public void setPos13(JTextField pos13) {
		this.pos13 = pos13;
	}
	public JTextField getPos21() {
		return pos21;
	}
	public void setPos21(JTextField pos21) {
		this.pos21 = pos21;
	}
	public JTextField getPos22() {
		return pos22;
	}
	public void setPos22(JTextField pos22) {
		this.pos22 = pos22;
	}
	public JTextField getPos23() {
		return pos23;
	}
	public void setPos23(JTextField pos23) {
		this.pos23 = pos23;
	}
	public JTextField getPos31() {
		return pos31;
	}
	public void setPos31(JTextField pos31) {
		this.pos31 = pos31;
	}
	public JTextField getPos32() {
		return pos32;
	}
	public void setPos32(JTextField pos32) {
		this.pos32 = pos32;
	}
	public JTextField getPos33() {
		return pos33;
	}
	public void setPos33(JTextField pos33) {
		this.pos33 = pos33;
	}

	public JTextField getPos11() {
		return pos11;
	}

	public void setPos11(JTextField pos11) {
		this.pos11 = pos11;
	}
	
	
	
	
	
}
