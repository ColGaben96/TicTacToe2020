package co.edu.unbosque.view;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

/**
 * @author https://www.rgagnon.com/javadetails/java-0198.html
 *
 */
public class JTextFieldLimit extends PlainDocument {
	  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int limit;
	  // optional uppercase conversion
	  private boolean toUppercase = false;
	  
	  JTextFieldLimit(int limit) {
	   super();
	   this.limit = limit;
	   }
	   
	  JTextFieldLimit(int limit, boolean upper) {
	   super();
	   this.limit = limit;
	   toUppercase = upper;
	   }
	 
	  public void insertString
	    (int offset, String  str, AttributeSet attr)
	      throws BadLocationException {
	   if (str == null) return;

	   if ((getLength() + str.length()) <= limit) {
	     if (toUppercase) str = str.toUpperCase();
	     super.insertString(offset, str, attr);
	     }
	   }
	}
