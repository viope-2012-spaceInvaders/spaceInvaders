/*BattleField is a class describing the battlefield (that is to say, the game screen). It
can be broadly described as a matrix: every element of this matrix will contain an alien,
a gun, a shot, a casemate or will be empty. An instance of BattleField represents a
snapshot of the current battlefield configuration.*/

import java.io.*;
import java.util.StringTokenizer;
import java.lang.Integer;
import java.lang.String;

public class BattleField {

	//FIELD
	private int gunCounter=0;
	protected BattleFieldElement[][] battlefield;  // do not have to containt any null value
	protected static int rows;
	protected static int columns;						
	private String filename;					 //name of the file where the configurations used (saved,restored...)
										 
	// CONSTRUCTOR
	public BattleField(String filename) throws IllegalElementException, IllegalPositionException {
		
		setFilename(filename);
		reload();
		//	write();
		
	}
	
	//METHODS
	public String getFilename() {				
		return this.filename;					
	}
										 
	public void setFilename(String s) {			
		this.filename= s;						
	}
		  
	public BattleFieldElement getBattleFieldElement(int x, int y){
		return battlefield[x][y];						//what if the position has been forced to null before the call? Manage it here or somewhere else?
	}										

	public String toString(){	
		return getBattleField();									
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
	}										

	public String getBattleField() {
		int itemCounter=0; 	
		//int a=0;
		String item = this.battlefield[0][0].toString();												
		String Encode = this.battlefield.length + "|" + this.battlefield[0].length + "|";				//Encode start with  #rows | #column |
		//testing
		//System.out.println("encode: "+Encode);
		//System.out.println("row: "+rows);
		//System.out.println("columns: "+columns);
		for (int i = 0 ; i < rows; i++) {
			if(i>0) {
				Encode=Encode+itemCounter+item+"$";											//add $ when newLine
				item = this.battlefield[i][0].toString();
				itemCounter=0;
			}
			for (int j = 0; j < columns; j++) {
			//	System.out.println(a++);
			//	System.out.println(Encode);
			//	System.out.println(i+" "+j+" "+ "item: |"+this.battlefield[i][j].toString()+"|");
				if(item.equals(this.battlefield[i][j].toString())) {								//if last item and this one are of the same class
					if(itemCounter==9){															// if is the 10th then write on the Encode string
						Encode=Encode + itemCounter + item;
						itemCounter=1;
					}	
					else																		//else increment the counter
						itemCounter++;
				} else {																	//else write on the string	
					Encode = Encode + itemCounter + item;
					itemCounter = 1;
					item = this.battlefield[i][j].toString();
				}//end if-else	
			}//end for(columns)	
		}//end for(rows)		
		
		return Encode+itemCounter + item + "$";
	}

	public void write() {					// append the current configuration to the current content of the file;
		
		BufferedWriter bw = null;
		
		try {
			bw = new BufferedWriter(new FileWriter(this.filename));
			bw.write(this.getBattleField()+"\n");
			bw.close();
		} catch (IOException e) {
			System.out.println("IOException in the write method !");
		} 

	}
	
	public void reload() throws IllegalElementException, IllegalPositionException {		// read again from filename the last-configuration of the battlefield 																									
		FileReader fr = null;
		BufferedReader bf = null;
		try {
			fr = new FileReader(this.filename);
			bf = new BufferedReader(fr);
			String str = "", line = "";

			while (str != null) {
				line = str;
				str = bf.readLine();
			}
			setBattleField(line); //Send to setBattleField method, the lastest configuration of the file
		
			bf.close();
			fr.close();
		} catch (FileNotFoundException e) {
			System.out.println("File not found in the reload method!");
		} catch (IOException e) {
			System.out.println("IOException in the reload method!");
		} 
	}
		
	public Object clone() throws CloneNotSupportedException {			//it should be modified, it returns an Object, not just a BattleFieldElement (e.g. clone a whole battlefield)
		 BattleFieldElement bf = null;
		    try {
	        	bf = (BattleFieldElement) super.clone();
	        } catch(CloneNotSupportedException e) {
	            System.out.println("Clone method not supported!");
	        }
	        bf = (BattleFieldElement)this.clone();
	        return bf;
	}											

	
	void setBattleFieldElement(int x, int y, BattleFieldElement bf) throws IllegalElementException, IllegalPositionException {

		BattleFieldElement b = bf; //initialisation of b
		
		//check if something different from a Gun is placed in the bottom row
	    if ((x == rows-1) && (!b.toString().equals("G")) && (!b.toString().equals(" ")) && (!b.toString().equals("S")) ) 
	  		throw new IllegalElementException("Only Gun, AlienShot or Empty cells can be placed in the bottom row");
		//check if something different from a RedSpacecraft is placed in the top row
		if ((y == 0) && (!b.toString().equals("R"))  && ((!b.toString().equals(" "))) && (!b.toString().equals("s")) ) 
	  		throw new IllegalElementException("Only a RedSpacecraft, Gunshot or Empty Cells can be placed in the top row");
			
			switch(b.toString()){
				case "R":	if(x != 0) {
								throw new IllegalPositionException("RedSpacecraft cannot be placed in line "+x);
							}
							battlefield[x][y] = b;
							break;
						  
				case "G":	 if(gunCounter>0) {
								throw new IllegalElementException("Only one Gun per BattleField");
							}
							if(x != rows-1) {
								throw new IllegalPositionException("The Gun must be placed in the bottom line of the BattleField");
							}
							gunCounter++;
							battlefield[x][y]= b;
							break;
						
				case "C": 	if((x==0)||(x==rows-1)) {
								throw new IllegalPositionException("Casemates can't be placed in bottom or top line");
							}
							battlefield[x][y]= b;
							break;
							
				default: 	battlefield[x][y]= b;
			}	
			
	}
		
	public void setBattleField(String s) throws IllegalElementException, IllegalPositionException {   // a method initializing the battle-field configuration as specified in the parameter: 
		try{
			String config_line = s;
			StringTokenizer st = new StringTokenizer(config_line,"|");
			
			//Get the rows from the String
			String s_rows = st.nextToken();
			rows = Integer.parseInt(s_rows);
			
			//Get the columns from the String
			String s_columns = st.nextToken();
			columns = Integer.parseInt(s_columns);
			
			battlefield = new BattleFieldElement[rows][columns];
			
			//The rest of the String (Positions of the BattlefieldElements
			String result = st.nextToken();
			
			int i=0;
			int x=0;
			int y=0;
			int numberOfItem=0;
			String toBeConverted;			//had a problem with the parseint couse it require a String (not a character)
			BattleFieldElement b=null;

			while(i<result.length()){
				if(result.charAt(i)=='$'){				//this if check if the current char is a $, and in the case it is, set the newLine
					x++;		//newLine
					y=0;		
					result = result.substring(i+1);
					i=0;
					//System.out.print(result);
					continue;
				}
				
				if(i%2==0){				// 0-2-4-6 etc are always numbers
					toBeConverted=""+result.charAt(i);
					numberOfItem=Integer.parseInt(toBeConverted);
				}
				else {
					for(int k=0;k<numberOfItem;k++){
						switch (result.charAt(i)) { 
							case ' ': 	b=new Empty(x,y);
										setBattleFieldElement(x, y, b);
										break; 
										
							case 'R':	b=new RedSpacecraft(x,y);
										setBattleFieldElement(x, y, b);
										break;
										
							case 'A': 	b=new OneStepAlien(x,y);
										setBattleFieldElement(x, y, b);
										break;  
							
							case 'C': 	b=new Casemate(x,y);
										setBattleFieldElement(x, y, b);
										break;  
										
							case 'G': 	b=new Gun(x,y);
										setBattleFieldElement(x, y, b);
										break;
										
							case 's': 	b=new GunShot(x,y);
										setBattleFieldElement(x, y, b);
										break;  
										
							case 'S': 	b=new AlienShot(x,y);
										setBattleFieldElement(x, y, b);
										break; 
																
							default: 	break; // must throw an illegal string filename exception
						}//end switch
						y++;
					}//end for
				}//end else
				i++;
			}//end while
		} catch(NullPointerException e){
			System.out.println("test");
		} catch(ArrayIndexOutOfBoundsException e){
			System.out.println("test2");
		}
		
	}

	void move() throws IllegalElementException, IllegalPositionException{  	
		//IMPORTANT : there is an exception : 
		//If the shot is just above a gun, the gun will move after, but it will be destroyed... 
		//We will see this later, it's not very important for the moment
		
		//IMPORTANT 2 : We must use the function clone(), to clone the object in y+1, 
		//Or we will lose it. The problem is I don't really know how to do this...
			
		int consecutiveRed=0;
		
		for(int y=0; y<rows; y++)	{							// each row starting from 0 
			for(int x=0; x<columns; x++) {						// each column starting from 0
				System.out.println("A) "+battlefield[x][y].toString());
				switch(battlefield[x][y].toString()) {		// switch to the case returned from the toString() of the battlefield[x][y]
										
								//CaseMate & Empty
					case " ":
					case "C": 	break;							
					
								//RedSpacecraft
					case "R":	if(consecutiveRed==0){
									setBattleFieldElement(x,y,new Empty(x,y));			//replace with an empty cell
								}
								consecutiveRed=0;
								if(battlefield[x+1][y].toString().equals(" ")){			//if is near an empty cell
									setBattleFieldElement(x+1,y,battlefield[x][y]);		//move it
									x++;												//next pos won't move
								}
								if(battlefield[x+1][y].toString().equals("S")){			//if near a shot
									setBattleFieldElement(x,y,new Empty(x,y));			//replace next pos with an empty cell too
									x++;												//next pos won't move
								}
								if(battlefield[x+1][y].toString().equals("R")){			//if near a R
									consecutiveRed=1;									//next one will not be replaced, just moved
								}
								break;
					/*
					//Gun
					case "G": 	if(toBeMoved.getXOffset()!=0){						// otherway, if the offset is different from 0
									battlefield[x][y].move(x+Gun.direction,y);	//move it 1 step to its current direction
									break;
								} 
								else {																//otherway call the changeDirection before moving it
									Gun.changeDirection();
									battlefield[x][y].move(x+Gun.direction,y);
									break;
								}		
								if(columns==1) {					// if the matrix has only 1 column, nothing happens
									break;
								}
						
										
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
					*/
					default:	break;
					

				}//end switch
				x++;
			}
		}
	}
	

}//end of class
