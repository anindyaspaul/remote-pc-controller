package gui;

import java.awt.Color;
import java . awt . GridBagConstraints ;
import java . awt . GridBagLayout ;
import java . awt . Insets ;
import javax.swing.BorderFactory;
import javax . swing . JFrame ;

public class Frame extends JFrame
{
//    private final Panel_11 b1panel ;
    private final Panel_21 panel1 ;
    private final Panel_31 panel2 ;
    private final Panel_41 b2panel ;
    
  
    public  Frame () 
    {
    	super("Remote PC Controller");
        setLayout ( new GridBagLayout () ) ;
        setSize ( 300 , 500 ) ;
        setDefaultCloseOperation ( JFrame . EXIT_ON_CLOSE ) ;
//        setUndecorated ( true ) ;
        getRootPane().setBorder(BorderFactory.createMatteBorder(4, 4, 4, 4, Color.lightGray));  // frame border 
        GridBagConstraints gbc = new GridBagConstraints () ; // we have a ( 4 , 1 ) grid  
        gbc . fill = GridBagConstraints . BOTH ;
       
//        gbc . gridx = 0 ;
//        gbc . gridy = 0 ;
//        gbc . ipady = 0 ;
//        b1panel = new Panel_11 () ;
//        add ( b1panel , gbc ) ;  // add panel in (1,1) point of grid which contain minimize , exit button and text
       
        gbc . insets = new Insets ( 10 , 10 , 0 , 10 ) ;
        gbc . gridx = 0 ;
        gbc . gridy = 0 ;
        gbc . ipady = 80 ;
        gbc . ipadx = 10 ;
        panel1 = new Panel_21 () ; 
        add ( panel1 , gbc ) ;  // add panel in (2,1) point of grid which contain text , your ip and your password
        
        gbc . insets = new Insets ( 10 , 10 , 0 , 10 ) ;
        gbc . gridx = 0 ;
        gbc . gridy = 1 ;
        gbc . ipady = 80 ;
        panel2 = new Panel_31 () ;
        add ( panel2 , gbc ) ; // add panel in (3,1) point of grid which contain text , your friends ip and password
        
        gbc . insets = new Insets ( 5 , 5 , 5 , 5 ) ;
        gbc . gridx = 0 ;
        gbc . gridy = 2 ;
        gbc . ipady = 0 ;
        b2panel = new Panel_41 () ;
        add ( b2panel , gbc ) ;// add panel in (3,1) point of grid which contain connect button
       
        pack();
        setVisible(true) ;    
  
    }
    
}
