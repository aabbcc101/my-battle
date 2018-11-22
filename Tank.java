package battle2;

import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;

public class Tank {
	private Image tank;
	private Image tankLeft;
	private Image tankRight;
	private Image tankDown;
	private int tankX;
	private int tankY;
	private int tankDegree;
	private final int DOT_SIZE = 32;
	private boolean left = false;
	private boolean right = true;
	private boolean up = false;
	private boolean down = false;
	
	public void loadImages() {
		 ImageIcon iia = new ImageIcon("src/battle2/battle32.png");
		 tank = iia.getImage();
		 ImageIcon iib = new ImageIcon("src/battle2/battleLeft32.png");
		 tankLeft = iib.getImage();
		 ImageIcon iic = new ImageIcon("src/battle2/battleRight32.png");
		 tankRight = iic.getImage();
		 ImageIcon iid = new ImageIcon("src/battle2/battleDown32.png");
		 tankDown = iid.getImage();
	}
	
	public int getDotSize() {
		return DOT_SIZE;
	}
	public void moveTank() {
		if(left) {
			tankX -= DOT_SIZE/2;
			tankDegree = -90;
		}
		if(right) {
			tankX += DOT_SIZE/2;
			tankDegree = 90;
		}
		if(up) {
			tankY -= DOT_SIZE/2;
			tankDegree = 0;
		}
		if(down) {
			tankY += DOT_SIZE/2;
			tankDegree = 180;
		}
	}
	
	public int getX() {
		return tankX;
	}
	public int getY() {
		return tankY;
	}
	
	public void setX(int x) {
		tankX = x;
	}
	public void setY(int y) {
		tankY = y;
	}
	public void setDegree(int d) {
		tankDegree = d;
	}
	public int getDegree() {
		return tankDegree;
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
	public Image getImage() {
		return tank;
	}
	public Image getImageLeft() {
		return tankLeft;
	}
	public Image getImageRight() {
		return tankRight;
	}
	public Image getImageDown() {
		return tankDown;
	}
	
	
	public boolean leftEq() {
		if (this.tankDegree == -90) {
			return true;
		}
		else{
			return false;
		}
	}
	public boolean rightEq() {
		if (this.tankDegree == 90) {
			return true;
		}
		else{
			return false;
		}
	}
	public boolean downEq() {
		if (this.tankDegree == 180) {
			return true;
		}
		else{
			return false;
		}
	}
	
	public void stop() {
		left = false;
		up = false;
 		down = false;
		right = false;
	}
	
	public int shot() {
		if (this.rightEq() == true) {
	//		Shot newShot = new Shot(1);
			return 1;
			
		}
		else if (this.leftEq() == true) {
	//		Shot newShot = new Shot(0);
			return 0;
		}
		else if (this.downEq() == true) {
	//		Shot newShot = new Shot(4);
			return 4;
		}
		else {
	//		Shot newShot = new Shot(3);
			return 3;
		}
	}
	
}
