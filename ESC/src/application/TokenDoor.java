package application;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class TokenDoor extends Cell {

	public TokenDoor(String name, boolean playerPass, boolean enemyPass, int xCoordinate, int yCoordinate) {
		super(name, playerPass, enemyPass, xCoordinate, yCoordinate);
		this.playerPass = playerPass;
		this.enemyPass = enemyPass;
		super.cellImage = new Image("https://kingfisher.scene7.com/is/image/Kingfisher/productTemplate?$baseImage=Kingfisher/5016536495741_01c");
		super.cellView = new ImageView(cellImage);
		super.cellView.setFitHeight(CELL_SIZE);
		super.cellView.setFitWidth(CELL_SIZE);
		
	}
	public ImageView getTokenDoorView() {
		
		return super.getView();
		
	}

}