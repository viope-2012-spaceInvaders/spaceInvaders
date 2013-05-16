import pt.ipleiria.estg.dei.stackemup.gridpanel.GridPanel;
import pt.ipleiria.estg.dei.stackemup.gridpanel.SingleImageCellRepresentation;


public class ImageManageGun {
private SingleImageCellRepresentation image;
	
	public ImageManageGun(BattleField bf, GridPanel gp ) {

			for (int j = 0; j < bf.columns; j++) {
				switch (bf.battlefield[bf.rows-2][j].toString()) {
				case " ":
					this.image = new SingleImageCellRepresentation("/image/_.png");
					gp.put(j,bf.rows-2, this.image);
					break;
				case "G":
					this.image = new SingleImageCellRepresentation("/image/G.png");
					gp.put(j,bf.rows-2, this.image);
					break;

				default:
					break;
				}
			}
		
	}

}