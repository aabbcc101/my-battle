package battle2;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Shot {
	private Image shot;
	private int shotX;
	private int shotY;
	private boolean left = false;
	private boolean right = false;
	private boolean up = false;
	private boolean down = false;
	private int side;
	
	private final int DOT_SIZE = 32;
	public int getDotSize() {
		return DOT_SIZE;
	}
	public void loadImages() {
		 ImageIcon iia = new ImageIcon("src/battle2/shot32.png");
		 shot = iia.getImage();
	}
	public int getX() {
		return shotX;
	}
	public int getY() {
		return shotY;
	}
	
	public void setX(int x) {
		shotX = x;
	}
	public void setY(int y) {
		shotY = y;
	}
	public void leftTrue() {
		left = true;
		up = false;
 		down = false;
		right = false;
	}
	public void rightTrue() {
		left = false;
		up = false;
 		down = false;
		right = true;
	}
	public void upTrue() {
		left = false;
		up = true;
 		down = false;
		right = false;
	}
	public void downTrue() {
		left = false;
		up = false;
 		down = true;
		right = false;
	}
	
	public void sideR(int r) {
		side = r;
	}
	
	public void moveShot() {
		
		switch (side) {
			case 0: this.leftTrue(); break;
			case 1: this.rightTrue(); break;
			case 3: this.upTrue(); break;
			case 4: this.downTrue(); break;
			}
			
			if(left) {
				this.shotX -= DOT_SIZE/2;
			}
			if(right) {
				this.shotX += DOT_SIZE/2;
			}
			if(up) {
				this.shotY -= DOT_SIZE/2;
			}
			if(down) {
				this.shotY += DOT_SIZE/2;
			}
	}
	public Image getImage() {
		return shot;
	}
}
