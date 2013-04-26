/*BattleField is a class describing the battlefield (that is to say, the game screen). It
can be broadly described as a matrix: every element of this matrix will contain an alien,
a gun, a shot, a casemate or will be empty. An instance of BattleField represents a
snapshot of the current battlefield configuration.*/

import java.io.*;
import java.util.StringTokenizer;


public class BattleField {

	//FIELD
	private int gunCounter=0;
	private BattleFieldElement[][] battlefield;  //a field storing the initial battlefield configuration. Every element of this matrix must 
												 //contain a non-null value.
	protected static int rows;
	protected static int columns;						 //overall number of rows and columns of the battlefield.
	private String filename;					 //field containing the name of the file where the configurations should be saved and that is used 
													//to restore a saved configuration. 
										 
	// CONSTRUCTOR
	// a constructor configuring the battlefield, where filename is the filename
	// of a file containing some configurations(one per line): the last such
	// configuration becomes the current // configuration of the battlefield.
	public BattleField(String filename) throws IllegalElementException, IllegalPositionException {
		setFilename(filename);
		
		reload();
	}
	
	//METHODS
	
	public String getFilename() {				//	You should provide two methods
		return this.filename;					//	public String getFilename()
	}
										 
	public void setFilename(String s) {			//	void setFilename(String) with the obvious meaning.
		this.filename= s;						
	}
	
	//utility methods to set and retrieve a specific element on the battlefield;
	  
	void setBattleFieldElement(int x, int y, BattleFieldElement b) throws IllegalElementException, IllegalPositionException {
			//check if something different from a Gun is placed in the bottom row
	    if ((y == rows-1) && (!b.toString().equals("G")) && (!b.toString().equals(" ")) && (!b.toString().equals("S")) ) 
	  		throw new IllegalElementException("Only Gun, AlienShot or Empty cells can be placed in the bottom row");
			//check if something different from a RedSpacecraft is placed in the top row
			if ((y == 0) && (!b.toString().equals("R"))  && ((!b.toString().equals(" "))) && (!b.toString().equals("s")) ) 
	  			throw new IllegalElementException("Only a RedSpacecraft, Gunshot or Empty Cells can be placed in the top row");
			
			switch(b.toString()){
				case "R":	if(y != 0) {
						throw new IllegalPositionException("RedSpacecraft cannot be placed in line "+y);
	      			}
					battlefield[x][y]= b;
				break;
						  
				case "G": if(gunCounter>0) {
						throw new IllegalElementException("Only one Gun per BattleField");
					}
	            	if(y != rows-1) {
	            		throw new IllegalPositionException("The Gun must be placed in the bottom line of the BattleField");
	            	}
	            	gunCounter++;
	            	battlefield[x][y]= b;
				break;
						
				case "C": 	if((y==0)||(y==rows-1)) {
						throw new IllegalPositionException("Casemates can't be placed in bottom or top line");
			    	}
					battlefield[x][y]= b;
	         	break;
				//gunshot			
				default: battlefield[x][y]= b;
			}	
	}
		
	BattleFieldElement getBattleFieldElement(int x, int y){
		return battlefield[x][y];
	}										

	public String toString(){				// a method creating and returning a string rep-resenting the current battlefield configuration,
		return getBattleField();									// whose encoding is as specified above;
	}									

	public void setBattleField(String s) throws IllegalElementException, IllegalPositionException {   // a method initializing the battle-field configuration as specified in the parameter: 
		String config_line = s;
		StringTokenizer st = new StringTokenizer(config_line,"|");
		
		//Get the rows from the String
		String s_rows = st.nextToken();
		rows = Integer.parseInt(s_rows);
		
		//Get the columns from the String
		String s_columns = st.nextToken();
		columns = Integer.parseInt(s_columns);
		
		//The rest of the String (Positions of the BattlefieldElements
		String result = st.nextToken();

		int i = 0; //i : to trough the String; 
		int l = 0, k = 0; //l & k : to place the BattlefieldElements in the matrix; 
		int	itemCounter; //itemCounter : to count how many items of a BattlefieldElement there are
		
		char c = result.charAt(i); 
		String stringCounter = "";

		//Until the end of the String
        while (i < result.length()-1) {
        	
        	//While there isn't detection of a BattlefieldElement
	        while (c != ' ' && c != '$' && c != 'R' && c != 'A' && c != 'G' && c != 'C' && c != 's' && c != 'S') {
	        	stringCounter += String.valueOf(c); //to converting the String into a integer
	        	i++;
	        	c = result.charAt(i);
	        }

	        //Processing when BattlefieldElement detected
	        switch (c) { 
	        	case ' ': 
	        		for (itemCounter = Integer.parseInt(stringCounter);itemCounter>0;itemCounter--) {
	        			setBattleFieldElement(l, k, new Empty(l, k));
	        			k++;
	        		}
	        		break; 
	        	case '$':
	        		l++;
	        		k = 0;
	        		break;
	        	case 'R':
	        		setBattleFieldElement(l, k, new RedSpacecraft(l, k));
	        		break; 
	        	case 'A': 
	        		for (itemCounter = Integer.parseInt(stringCounter);itemCounter>0;itemCounter--) {
	        			setBattleFieldElement(l, k, new OneStepAlien(l, k));
	        			k++;
	        		}
	        		break;  
	        	case 'C': 
	        		for (itemCounter = Integer.parseInt(stringCounter);itemCounter>0;itemCounter--) {
	        			setBattleFieldElement(l, k, new Casemate(l, k));
	        			k++;
	        		}
	        		break;  
	        	case 'G': 
	        		setBattleFieldElement(l, k, new Gun(l, k));
	        		break;
	        	case 's': 
	        		for (itemCounter = Integer.parseInt(stringCounter);itemCounter>0;itemCounter--) {
	        			setBattleFieldElement(l, k, new GunShot(l, k));
	        			k++;
	        		}
	        		break;  
	        	case 'S': 
	        		for (itemCounter = Integer.parseInt(stringCounter);itemCounter>0;itemCounter--) {
	        			setBattleFieldElement(l, k, new AlienShot(l, k));
	        			k++;
    				}
	        		break;  
	        	default: 
	        		break;
	        }
	        
	        stringCounter = ""; //Reset of the stringCounter
	        
	        i++;
        	c = result.charAt(i); //
        }
	}

	public String getBattleField() {

		// method returning the current configuration of the battlefield, encoded as specified above;
			// 7|10|8-1R1-$4-3A1-1A1-$4-2C1-1A2-$4-2A4-$2-1C4A3-$2-1A7-$1-1G8-$ ("_" is a empty cell)
		int itemCounter=0; 	
		String item=battlefield[0][0].toString();
		String Encode = battlefield.length + "|" + battlefield[0].length + "|";
		for (int i = 0 ; i < rows; i++) {
			if(i>0) {
				Encode=Encode+"$";
			}
			for (int j = 0; j < columns; j++) {
				if(battlefield[i][j].toString().equals(item)) {
					if(itemCounter==9){
						Encode=Encode + itemCounter + item;
						itemCounter=1;
					}	
					else
						itemCounter++;
				} else {
					Encode=Encode + itemCounter + item;
					itemCounter=0;
					item=battlefield[i][j].toString();
				}	
			}	
		}		
		return Encode+itemCounter + item + "$";
	}


	
	// method returning the current configuration of the battlefield, encoded as specified above;
	// 7|10|8-1R1-$4-3A1-1A1-$4-2C1-1A2-$4-2A4-$2-1C4A3-$2-1A7-$1-1G8-$ ("-" is a empty cell)
							

	public void write(){					// a method appending the current configuration to the current content of the file;
		
	}

	public void reload() throws IllegalElementException, IllegalPositionException{					// a method reading again from the file named filename the configuration of the battlefield 
																									//(the last configuration found in the file is used);
		try {
			FileReader fr = new FileReader(this.filename);
			BufferedReader bf = new BufferedReader(fr);
			String str = "", line = "";
			try {
				while (str != null) {
					line = str;
					str = bf.readLine();
				}
				setBattleField(line); //Send to setBattleField method, the lastest configuration of the file
			} catch (IOException e) {
				System.out.println("IOException in the reload method!");
			}
		} catch (FileNotFoundException e) {
			System.out.println("File not found in the reload method!");
		}
	}
	
	public Object clone() throws CloneNotSupportedException {
		 BattleFieldElement bf = null;
		 
	        try {
	        	bf = (BattleFieldElement) super.clone();
	        } catch(CloneNotSupportedException e) {
	            System.out.println("Clone method not supported!");
	        }
	        bf = (BattleFieldElement)this.clone();
	        return bf;
	}											

	public void backup(String file) {
		File f = new File (file); 
			try {
			    FileWriter fw = new FileWriter (f);
			 
				String backup = this.getBattleField();
		
			    fw.write(backup);

			    fw.close();
			} catch (IOException exception) {
			    System.out.println ("Impossible to create the backup file !");
			}
	}										// makes a backup copy of the battlefield con-figuration, saving it onto a file whose name is passed
											// as an argument; the file is created from scratch;

	void move() throws IllegalElementException, IllegalPositionException{  	// a method that advances the configuration of one step, starting from the upper left corner and proceeding
		// left to right, one line at a time; the step must be performed in-place, without creating another copy
		// of the matrix: this can be obtained by suitably exploiting the methods provided by the
		// BattleFieldElement objects; the move() method handles all special cases (e.g., the collisions).

		
		//IMPORTANT : there is an exception : 
		//If the shot is just above a gun, the gun will move after, but it will be destroyed... 
		//We will see this later, it's not very important for the moment
		
		//IMPORTANT 2 : We must use the function clone(), to clone the object in y+1, 
		//Or we will lose it. The problem is I don't really know how to do this...
		
		for(int x=0; x<rows; x++)	{							// each row starting from 0 
			for(int y=0; y<columns; y++) {						// each column starting from 0
				
				switch(battlefield[x][y].toString()) {						// switch to the case returned from the toString() of the battlefield[x][y]
	
					//RedSpacecraft
					case "R":
						if (battlefield[x][y].getXOffset()==0) { // Detection if the RedSpaceCraft has reached the final column of the battlefield 
							setBattleFieldElement(x,y,new Empty(x,y));
						} else {
							battlefield[x][y].move(x,y+1);
							setBattleFieldElement(x,y,new Empty(x,y));
						}
					break;
					
					//CaseMate
					case "C": 	
					break;										// nothing happens
					
					//Gun
					case "G": 	
						if(rows==1) {					// if the matrix has only 1 column, nothing happens
							break;
						}
					
						if(battlefield[x][y].getXOffset()!=0){						// otherway, if the offset is different from 0
							battlefield[x][y].move(x+Gun.direction,y);	//move it 1 step to its current direction
							break;
						} else {																//otherway call the changeDirection before moving it
							Gun.changeDirection();
							battlefield[x][y].move(x+Gun.direction,y);
							break;
						}		
						
					//EmptyCell
					case " ": 
					break;										// nothing happens
					
					//OneStepAlien
					case "A": 	// to do
						if (battlefield[x][y].getXOffset()==0 || battlefield[x][y+OneStepAlien.armyDirection].toString() == "C") { // Detection if the OneStepAlien has reached the end of the Batllefield, or if there is a collide with a Casemate
							OneStepAlien.changeDirection();
							battlefield[x][y].move(x+OneStepAlien.armyDirection,y); 
							setBattleFieldElement(x,y,new Empty(x,y));
						} else {
							battlefield[x][y].move(x+OneStepAlien.armyDirection,y);
							setBattleFieldElement(x,y,new Empty(x,y));
						}
						
					break;
					
					//GunShot
					case "s": 
						if (battlefield[x][y].getYOffset()==0) { //End of the battlefield
						 //Shot will only be replaced by an empty cell -> done just before the break
						} else if (battlefield[x][y-1].toString() == " ") {
							battlefield[x][y].move(x,y-1);
		
						} else { 	//Collide anything
							setBattleFieldElement(x,y+1,new Empty(x,y+1)); //Destruction of the touched element
						}
						
						setBattleFieldElement(x,y,new Empty(x,y)); //Shot replaced by an empty cell
				
					break;
					
					//AlienShot
					case "S":
						if (battlefield[x][y].getYOffset()==0) { //End of the battlefield
							 //Shot will only be replaced by an empty cell -> done just before the break
						} else if (battlefield[x][y+1].toString() == " ") {
							battlefield[x][y].move(x,y+1);
	
						} else {
							if (battlefield[x][y+1].toString() == "G") { //Collide with a gun
								gunCounter--;
								System.out.println("Gun destroyed !");
								setBattleFieldElement(x,y+1,new Empty(x,y+1)); //Destruction of the gun
								setBattleFieldElement(rows-1,columns/2,new Gun(rows-1,columns/2)); //Gun replaced on the center of the Battlefield
							} else { //Collide with anything else
								setBattleFieldElement(x,y+1,new Empty(x,y+1)); //Destruction of the touched element
								
							}
						}
						
						setBattleFieldElement(x,y,new Empty(x,y)); //Shot replaced by an empty cell
						
					break;
					
					default:
					break;

				}
			}
		}
	}										// a method that advances the configuration of one step, starting from the upper left corner and proceeding
											// left to right, one line at a time; the step must be performed in-place, without creating another copy
											// of the matrix: this can be obtained by suitably exploiting the methods provided by the
											// BattleFieldElement objects; the move() method handles all special cases (e.g., the collisions).



/*Observe that the listed signatures don’t explicitly mention exceptions that methods
should possibly throw: the implementer will have to carefully judge when the former
have to be implemented.*/

}

//read the pdf to get more info about encoding