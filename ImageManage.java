import pt.ipleiria.estg.dei.stackemup.gridpanel.GridPanel;
import pt.ipleiria.estg.dei.stackemup.gridpanel.SingleImageCellRepresentation;


public class ImageManage {

	private SingleImageCellRepresentation image;
	
	public ImageManage(BattleField bf, GridPanel gp ) {
		for (int i = 0; i < bf.getRows(); i++) {
			for (int j = 0; j < bf.columns; j++) {
				switch (bf.battlefield[i][j].toString()) {
				case "A":
					this.image = new SingleImageCellRepresentation("/image/A.png");
					gp.put(j,i, this.image);
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
				case "C":
					this.image = new SingleImageCellRepresentation("/image/C.png");
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
					this.image = new SingleImageCellRepresentation("/image/ce.png");
					gp.put(j,i, this.image);
					break;
				case "g":
					this.image = new SingleImageCellRepresentation("/image/ge.png");
					gp.put(j,i, this.image);
					break;
				case "r":
					this.image = new SingleImageCellRepresentation("/image/re.png");
					gp.put(j,i, this.image);
					break;
//				case "G":
//					this.image = new SingleImageCellRepresentation("/image/G.png");
//					gp.put(j,i, this.image);
//					break;



				default:
					break;
				}
			}
		}
	}


	public ImageManage(GridPanel gp, int v, int h ) {
		this.image = new SingleImageCellRepresentation("/image/e.png");
		gp.put(h,v, this.image);

	}

	
}
