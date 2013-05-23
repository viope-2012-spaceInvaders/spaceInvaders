import pt.ipleiria.estg.dei.stackemup.gridpanel.GridPanel;
import pt.ipleiria.estg.dei.stackemup.gridpanel.SingleImageCellRepresentation;


public class ImageManage {

	private SingleImageCellRepresentation image;
	
	public ImageManage(BattleField bf, GridPanel gp ) {
		int nbA = 0;
		for (int i = 0; i < bf.getRows(); i++) {
			for (int j = 0; j < bf.columns; j++) {
				switch (bf.battlefield[i][j].toString()) {
				case "A":
					this.image = new SingleImageCellRepresentation("/image/A.png");
					gp.put(j,i, this.image);
					nbA++;
					break;
				case "R":
					this.image = new SingleImageCellRepresentation("/image/R.png");
					gp.put(j,i, this.image);
					break;
				case "s":
					this.image = new SingleImageCellRepresentation("/image/gs.png");
					gp.put(j,i, this.image);
					break;
				case "S":
					this.image = new SingleImageCellRepresentation("/image/as.png");
					gp.put(j,i, this.image);
					break;
				case "C":	if(i==BattleField.getRows()-1){
								this.image = new SingleImageCellRepresentation("/image/C.png");
							}
							else{
								this.image = new SingleImageCellRepresentation("/image/aC.png");
							}	
					gp.put(j,i, this.image);
					break;
				case " ":
					this.image = new SingleImageCellRepresentation("/image/_.png");
					gp.put(j,i, this.image);
					break;
				case "E":
					this.image = new SingleImageCellRepresentation("/image/e.png");
					gp.put(j,i, this.image);
					break;
				case "a":	
					this.image = new SingleImageCellRepresentation("/image/ae.png");
					gp.put(j,i, this.image);
					break;
				case "c":
					if(i==BattleField.getRows()-1){
						this.image = new SingleImageCellRepresentation("/image/ce.png");
					}
					else{
						this.image = new SingleImageCellRepresentation("/image/aCe.png");
						}
					gp.put(j,i, this.image);
					break;
				case "I":
					this.image = new SingleImageCellRepresentation("/image/he.png");
					gp.put(j,i, this.image);
					break;
				case "r":
					this.image = new SingleImageCellRepresentation("/image/re.png");
					gp.put(j,i, this.image);
					break;

				default:
					break;
				}
			}
		}
		if (nbA == 0) {
			Gui.levelFinished = true;
			
		}
	}


	public ImageManage(GridPanel gp, int v, int h ) {
		this.image = new SingleImageCellRepresentation("/image/e.png");
		gp.put(h,v, this.image);

	}

	
}
