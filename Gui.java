import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.lang.reflect.InvocationTargetException;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;
import pt.ipleiria.estg.dei.stackemup.gridpanel.GridPanel;
import java.awt.event.*;
import java.awt.Toolkit;



/**
 * 
 * Graphical interface class 
 *
 */
public class Gui extends JFrame implements KeyListener {

	private JPanel contentPane;
	private GridPanel battlefieldGrid;
	private BattleField bf;
	private int xGun;
	private Random ran;
	protected static boolean shootAllowed = true;
	protected static boolean gameOver = false;
	
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
	 * Creates the frame.
	 * @throws IllegalPositionException 
	 * @throws IllegalElementException 
	 */
	
	public Gui() throws IllegalElementException, IllegalPositionException {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Gui.class.getResource("/image/icon.png")));
		setTitle("Space Invaders - Erasmus Project 2013");
		bf = new BattleField("es-in.txt");
		this.addKeyListener(this);
		ran = new Random(0);
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

		for (int i = 0; i< bf.columns; i++) {
			if (bf.battlefield[bf.rows-1][i].toString().equals("G") ) {
				xGun = i;
				break;
			}
		}

		final Runnable iterator = new Runnable(){
				
			public void run() {
				try {
					ImageManage im = new ImageManage(bf,battlefieldGrid);
					ImageManageGun imGun = new ImageManageGun(bf,battlefieldGrid);
					bf.move();
					battlefieldGrid.repaint();
				} catch (IllegalElementException e) {
					e.printStackTrace();
				} catch (IllegalPositionException e) {
					e.printStackTrace();
				}			
			}
		};
		
		Thread novaThread = new Thread(){
			
			public void run(){	
				System.out.println ("Life : " + bf.life);
				System.out.println("Score : ");
				int sc = 0;
				int li = 3;
				while (gameOver == false) {
					int newli = bf.life;
					if (newli != li) {
						switch (bf.life) {
						case 1: 
							System.out.println("You lose a life ! \n"+bf.life+" life left");
							break;
						case 0:
							System.out.println("You lose the game !\nYour score is : "+bf.score);
							gameOver = true;
							break;
						default:
							System.out.println("You lose a life ! \n"+bf.life+" lifes left");
							break;
						}
						
						li = newli;
					}
				
					int newsc = bf.score;
					if (newsc != sc) {
						System.out.println(bf.score);
						sc = newsc;
					}
					for (int i = 0; i< bf.columns; i++) {
						if (bf.battlefield[bf.rows-1][i].toString().equals("G") ) {
							xGun = i;
							break;
						}
					}
					
					int numRand = ran.nextInt(100)+1;
					if (numRand < 7) {
						try {
							bf.setBattleFieldElement(0,bf.columns-1,new RedSpacecraft(0,bf.columns-1));
						} catch (Exception e ) {
							System.out.println("RedSPaceCraft problem in Gui.java");
						}
					}
					
					if (bf.dead) {
						shootAllowed = false;
						try {
							
							sleep(500);
							shootAllowed = true;
							bf.dead = false;
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
						
					try {
						SwingUtilities.invokeAndWait(iterator);
					} catch (InvocationTargetException e) {
						e.printStackTrace();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					try {
						ImageManage im = new ImageManage(bf,battlefieldGrid);
						ImageManageGun imGun = new ImageManageGun(bf,battlefieldGrid);
						sleep(300);
					} catch (InterruptedException e) {
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
        
        if (keyCode == 37 && left == false && xGun > 0 && gameOver==false) {	
        	left=true;		
        	try {
        		if (bf.battlefield[bf.rows-1][xGun-1].toString().equals("S")) {
        			bf.gunCounter--;
        			bf.life--;
        			bf.setBattleFieldElement(bf.rows-1, xGun, new Empty(bf.rows-1,xGun));
					bf.setBattleFieldElement(bf.rows-1, 0, new Gun(bf.rows-1,0));
					bf.setBattleFieldElement(bf.rows-1, xGun-1, new Empty(bf.rows-1,xGun-1));
					xGun=0;
					
        		} else {
        			//System.out.println("Move" + bf.battlefield[bf.rows-1][xGun-1].toString());
        			bf.battlefield[bf.rows-1][xGun].move(bf.rows-1,xGun-1);	
        			bf.battlefield[bf.rows-1][xGun-1]=bf.battlefield[bf.rows-1][xGun];
        			bf.setBattleFieldElement(bf.rows-1,xGun,new Empty(bf.rows-1,xGun));
        			
        		}
        		
        		xGun--;
    			ImageManageGun imGun = new ImageManageGun(bf,battlefieldGrid);
        		battlefieldGrid.repaint();

			} catch (IllegalElementException | IllegalPositionException | ArrayIndexOutOfBoundsException e1) {
				System.out.println("ArrayIndexOutOfBoundsException exception in Gui.java");
			}
        	
        } else if (keyCode == 39 && right == false && xGun < bf.columns-1 && gameOver==false) {
        	right=true;

        	try {
        		if (bf.battlefield[bf.rows-1][xGun+1].toString().equals("S")) {
        			bf.gunCounter--;
        			bf.life--;
        			bf.setBattleFieldElement(bf.rows-1, xGun, new Empty(bf.rows-1,xGun));
        			bf.setBattleFieldElement(bf.rows-1, xGun+1, new Empty(bf.rows-1,xGun+1));
					bf.setBattleFieldElement(bf.rows-1, 0, new Gun(bf.rows-1,0));
					xGun=0;	
        		} else {
	        		bf.battlefield[bf.rows-1][xGun].move(bf.rows-1,xGun+1);	
	    			bf.battlefield[bf.rows-1][xGun+1]=bf.battlefield[bf.rows-1][xGun];
	    			bf.setBattleFieldElement(bf.rows-1,xGun,new Empty(bf.rows-1,xGun));
        		}
        		xGun++;
        		ImageManageGun imGun = new ImageManageGun(bf,battlefieldGrid);
        		battlefieldGrid.repaint();
        		
			} catch (IllegalElementException | IllegalPositionException | ArrayIndexOutOfBoundsException e1) {
				System.out.println(xGun+" = "+e1);
			}	
			
        } else if (keyCode == 32 && shot == false && shootAllowed && gameOver==false) {
        	shot = true;
        	try {
				bf.setBattleFieldElement(bf.rows-2,xGun,new GunShot(bf.rows-2,xGun));
				
				ImageManage im = new ImageManage(bf,battlefieldGrid);
				battlefieldGrid.repaint();
			} catch (IllegalElementException | IllegalPositionException e1) {
				System.out.println("Probel shot inside the Gui.java");
			} 
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
