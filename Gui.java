import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.lang.reflect.InvocationTargetException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

import pt.ipleiria.estg.dei.stackemup.gridpanel.GridPanel;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.*;

import javax.swing.*;
import java.awt.SystemColor;
import java.awt.Toolkit;
 

public class Gui extends JFrame implements KeyListener {
//	public final static Color black;
	private JPanel contentPane;
	private GridPanel battlefieldGrid;
	private BattleField bf;
	private int xGun;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Gui frame = new Gui();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	

	/**
	 * Create the frame.
	 * @throws IllegalPositionException 
	 * @throws IllegalElementException 
	 */
	public Gui() throws IllegalElementException, IllegalPositionException {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Gui.class.getResource("/image/icon.png")));
		setTitle("Space Invaders");
		bf = new BattleField("es-in.txt");
		this.addKeyListener(this);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 50*bf.getColumns(),30+50*bf.getRows());
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		battlefieldGrid = new GridPanel();
		battlefieldGrid.setForeground(Color.BLACK);
		battlefieldGrid.setBackground(new Color(0, 0, 0));
		battlefieldGrid.setShowGridLines(false);
		battlefieldGrid.setRows(bf.getRows());
		battlefieldGrid.setColumns(bf.getColumns());
		
		contentPane.add(battlefieldGrid, BorderLayout.CENTER);
		
		xGun = 0;
		System.out.println(bf.rows-1 +"k");
		
		
		for (int i = 0; i< bf.columns; i++) {
			
			if (bf.battlefield[bf.rows-1][i].toString().equals("G") ) {
				xGun = i;
				
				//System.out.println( bf.battlefield[bf.rows-1][xGun].getXOffset());
				break;
			}
		}
		
		//bf.setBattleFieldElement(bf.rows-1,xGun,new Gun(bf.rows-1,xGun));
		
		final Runnable iterator = new Runnable(){
			
			
			public void run() {
//	we put the move stuff here
				try {
					ImageManage im = new ImageManage(bf,battlefieldGrid);
					bf.move();
					battlefieldGrid.repaint();
				} catch (IllegalElementException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalPositionException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
			}
		};
		
		Thread novaThread = new Thread(){
			public void run(){
				
				while (true) {
					try {
						SwingUtilities.invokeAndWait(iterator);
					} catch (InvocationTargetException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					try {
						sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		};
		novaThread.start();


	}

	
	static boolean left= false;
	static boolean right= false;
	static boolean shot= false;
	

	public void keyPressed(KeyEvent e) {
		
		int keyCode = e.getKeyCode();
        
        if (keyCode == 37 && left == false && xGun > 0) {
        	System.out.println("<-");
        	left=true;
        	
        	try {
        		bf.setBattleFieldElement(bf.rows-1,xGun,new Empty(bf.rows-1,xGun));
        		bf.gunCounter--;
        		bf.setBattleFieldElement(bf.rows-1,xGun-1,new Gun(bf.rows-1,xGun-1));
        		
        		
        		ImageManage im = new ImageManage(bf,battlefieldGrid);
        		xGun--;
        		System.out.println(xGun);
        		battlefieldGrid.repaint();

			} catch (IllegalElementException | IllegalPositionException | ArrayIndexOutOfBoundsException e1) {
				// TODO Auto-generated catch block
				System.out.println("ArrayIndexOutOfBoundsException exception in Gui.java");
			}
        	
        } else if (keyCode == 39 && right == false && xGun < bf.columns-1) {
        	System.out.println("->");
        	right=true;

        	try {
        		
        		bf.setBattleFieldElement(bf.rows-1,xGun,new Empty(bf.rows-1,xGun));
        		bf.gunCounter--;
        		bf.setBattleFieldElement(bf.rows-1,xGun+1,new Gun(bf.rows-1,xGun+1));
        		
        		xGun++;
        		System.out.println(xGun);
        		ImageManage im = new ImageManage(bf,battlefieldGrid);
        		battlefieldGrid.repaint();
        		
			} catch (IllegalElementException | IllegalPositionException | ArrayIndexOutOfBoundsException e1) {
				// TODO Auto-generated catch block
				System.out.println("ArrayIndexOutOfBoundsException exception in Gui.java");
			}		//move it
				//h++;												//next pos won't move
			//	break;
			//}
			
        } else if (keyCode == 32 && shot == false) {
        	System.out.println("|");
        	shot = true;
        	
        }

	}

	public void keyReleased(KeyEvent e) {
		

		int keyCode = e.getKeyCode();
        if (keyCode == 37) {
        	left=false;
        } else if (keyCode == 39) {
        	right=false;
        } else if (keyCode == 32) {
        	shot = false;
        }
		
	}


	public void keyTyped(KeyEvent e) {

	}

}
