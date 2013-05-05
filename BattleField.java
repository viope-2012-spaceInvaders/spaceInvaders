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
		
	}
	
	//METHODS
	public String getFilename() {				
		return this.filename;					
	}
										 
	public void setFilename(String s) {			
		this.filename= s;						
	}
		  
	public BattleFieldElement getBattleFieldElement(int v, int h){
		return battlefield[v][h];						//what if the position has been forced to null before the call? Manage it here or somewhere else?
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
		String item = this.battlefield[0][0].toString();												
		String Encode = this.battlefield.length + "|" + this.battlefield[0].length + "|";				//Encode start with  #rows | #column |
		for (int v = 0 ; v < rows; v++) {
			if(v>0) {
				Encode=Encode+itemCounter+item+"$";											//add $ when newLine
				item = this.battlefield[v][0].toString();
				itemCounter=0;
			}
			for (int h = 0; h < columns; h++) {
				if(item.equals(this.battlefield[v][h].toString())) {								//if last item and this one are of the same class
					if(itemCounter==9){															// if is the 10th then write on the Encode string
						Encode=Encode + itemCounter + item;
						itemCounter=1;
					}	
					else																		//else increment the counter
						itemCounter++;
				} else {																	//else write on the string	
					Encode = Encode + itemCounter + item;
					itemCounter = 1;
					item = this.battlefield[v][h].toString();
				}//end if-else	
			}//end for(columns)	
		}//end for(rows)		
		
		return Encode+itemCounter + item + "$";
	}

	public void write() {					// append the current configuration to the current content of the file;
		
		BufferedWriter bw = null;
		
		try {
			bw = new BufferedWriter(new FileWriter(this.filename, true));
			bw.newLine();
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

	
	void setBattleFieldElement(int v, int h, BattleFieldElement b) throws IllegalElementException, IllegalPositionException {
		
		//check if something different from a Gun is placed in the bottom row
	    if ((v == rows-1) && (!b.toString().equals("G")) && (!b.toString().equals(" ")) && (!b.toString().equals("S")) ) 
	  		throw new IllegalElementException("Only Gun, AlienShot or Empty cells can be placed in the bottom row");
		//check if something different from a RedSpacecraft is placed in the top row
		if ((v == 0) && (!b.toString().equals("R"))  && ((!b.toString().equals(" "))) && (!b.toString().equals("s")) ) 
	  		throw new IllegalElementException("Only a RedSpacecraft, Gunshot or Empty Cells can be placed in the top row");
			
			switch(b.toString()){
				case "R":	if(v != 0) {
								throw new IllegalPositionException("RedSpacecraft cannot be placed in line "+v);
							}
							battlefield[v][h] = b;
							break;
						  
				case "G":	 if(gunCounter>0) {
								throw new IllegalElementException("Only one Gun per BattleField");
							}
							if(v != rows-1) {
								throw new IllegalPositionException("The Gun must be placed in the bottom line of the BattleField");
							}
							gunCounter++;
							battlefield[v][h]= b;
							break;
						
				case "C": 	if((v==0)||(v==rows-1)) {
								throw new IllegalPositionException("Casemates can't be placed in bottom or top line");
							}
							battlefield[v][h]= b;
							break;
							
				default: 	battlefield[v][h]= b;
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
			int h=0;
			int v=0;
			int numberOfItem=0;
			String toBeConverted;			//had a problem with the parseint 'couse it require a String (not a character)
			BattleFieldElement b=null;

			while(i<result.length()){
				if(result.charAt(i)=='$'){				//is the char a $?
					v++;								//YES:  newLine
					h=0;										//start from the first column
					result = result.substring(i+1);				//cut the part done to the result
					i=0;										//restart from the first char of result
					continue;									//restart the loop
				}
				
				if(i%2==0){								// is it a number?
					toBeConverted=""+result.charAt(i);				//then convert to an int	
					numberOfItem=Integer.parseInt(toBeConverted);
				}
				else {									//it isn't!
					for(int k=0;k<numberOfItem;k++){		//set "numberOfItem" element in the battlefield 
						switch (result.charAt(i)) { 
							case ' ': 	b=new Empty(v,h);
										setBattleFieldElement(v, h, b);
										break; 
										
							case 'R':	b=new RedSpacecraft(v,h);
										setBattleFieldElement(v, h, b);
										break;
										
							case 'A': 	b=new OneStepAlien(v,h);
										setBattleFieldElement(v, h, b);
										break;  
							
							case 'C': 	b=new Casemate(v,h);
										setBattleFieldElement(v, h, b);
										break;  
										
							case 'G': 	b=new Gun(v,h);
										setBattleFieldElement(v, h, b);
										break;
										
							case 's': 	b=new GunShot(v,h);
										setBattleFieldElement(v, h, b);
										break;  
										
							case 'S': 	b=new AlienShot(v,h);
										setBattleFieldElement(v, h, b);
										break; 
																
							default: 	break; // must throw an illegal string filename exception
						}//end switch
						h++; //move to next pos;
				
					}//end for
				}//end else
				
				i++;	//next char
			
			}//end while
		} catch(NullPointerException e){
			System.out.println("String given doesn't fit enought the matrix");
		} 
		
	}	
	
	void move() throws IllegalElementException, IllegalPositionException{ 
	  
		int consecutiveRed=0;
		for(int v=0; v<rows; v++)	{							// each row starting from 0 
			for(int h=0; h<columns; h++) {						// each column starting from 0
				switch(battlefield[v][h].toString()) {		// switch to the case returned from the toString() of the battlefield[x][y]					
								//CaseMate & Empty
					case " ":
					case "C": 	break;							
					
								//RedSpacecraft
					case "R":   
								if(battlefield[v][h].getXOffset()==0) {						//if near border
									if(consecutiveRed==0)									//and before it there weren't a R
										setBattleFieldElement(v,h,new Empty(v,h));				//replace with an empty cell
									break;													 //just break otherwise
								} 
								else {														//if far from border instead
									if(consecutiveRed==0){									//was the item before him a R?
										setBattleFieldElement(v,h,new Empty(v,h));			//NO: replace with an empty cell and ....
									}
									consecutiveRed=0;										//nevermind the past!
									if(battlefield[v][h+1].toString().equals(" ")){			// if next is empty
										setBattleFieldElement(v,h+1,new RedSpacecraft(v,h+1));	//...move to the next pos	
										h++;													//and leave it the next loop 
										break;
									}
									if(battlefield[v][h+1].toString().equals("s")){			//if next is a shot
										setBattleFieldElement(v,h+1,new Empty(v,h+1));			// ...move to the ..OoOoh noooes..BOOOM...just empty cell!
										h++;												// leave this empty cell here, go on!
										break;
									}
									if(battlefield[v][h+1].toString().equals("R")){			//if next is a R
										consecutiveRed=1;									//...remember to not replaced next R
									}
								}//end else
								break;//end case R					//i'm not sure if this code work			
					
					case "s": 	if(battlefield[v][h].getYOffset()<1){
									setBattleFieldElement(v,h,new Empty(v,h));  
								}else{
									String elementType = battlefield[v+1][h].toString();
									if(elementType.equals(" ")||elementType.equals("A")||elementType.equals("C")||elementType.equals("S")){
										setBattleFieldElement(v+1,h, new GunShot(v+1,h));
									}
						
								}
								break;
					
					case "S":	if(battlefield[v][h].getYOffset()<1){
									setBattleFieldElement(v,h,new Empty(v,h)); 
								}else{
									String elementType = battlefield[v-1][h].toString();
									if(elementType.equals(" ")||elementType.equals("A")||elementType.equals("C")||elementType.equals("S")){
										setBattleFieldElement(v-1,h, new GunShot(v-1, h));
									}
						
								}
								break;
					
					case "G":	
								int toAdd=Gun.direction;
								if(battlefield[v][h].getXOffset()!=0){				// otherway, if the offset is different from 0
									setBattleFieldElement(v,h,new Empty(v,h));	//move it 1 step to its current direction
									gunCounter--;
									if(battlefield[v][h+toAdd].toString().equals(" ")){			//if is near an empty cell
										setBattleFieldElement(v,h+toAdd,new Gun(v,h+toAdd));		//move it
										h++;												//next pos won't move
										break;
									}
									if(battlefield[v][h+toAdd].toString().equals("S")){			//if near an Alien shot
										setBattleFieldElement(v,h,new Empty(v,h));			//replace next pos with an empty cell
										h++;												//next pos won't move
										break;
									}
								} 
								else {									//otherway call the changeDirection before moving it
									Gun.changeDirection();
									toAdd=Gun.direction;
									setBattleFieldElement(v,h,new Empty(v,h));
									gunCounter--;
									if(battlefield[v][h+toAdd].toString().equals(" ")){			//if is near an empty cell
										setBattleFieldElement(v,h+toAdd,new Gun(v,h+toAdd));		//move it
										h++;												//next pos won't move
										break;
									}
									if(battlefield[v][h+toAdd].toString().equals("S")){			//if near an Alien shot
										setBattleFieldElement(h,v,new Empty(v,h));			//replace next pos with an empty cell
										h++;												//next pos won't move
									}
								break;
								}		
					
					
					//
				default:  break;
					

				}//end switch
			}//For2
		} //for1
	}//end of method

}//end of class

