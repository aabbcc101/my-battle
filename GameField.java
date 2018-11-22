package battle2;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;

import javax.swing.JPanel;
import javax.swing.Timer;

public class GameField extends JPanel implements ActionListener{
	
	private final int SIZE = 320; // количество пикселей в данном поле
	private final int ALL_DOTS = 10; // Количество квадратиков в данном поле
	private Timer timer;
	private boolean inGame = true;
	private Tank myTank = new Tank();
	private TankEnemy enemy  = new TankEnemy();
	
	//shot
	private Shot newShot = new Shot();
	//my
	private Shot[] myShots = new Shot[5];
	private boolean[] booleanShots = new boolean[5]; 
	//enemy
	private ShotEnemy[] enemyShots = new ShotEnemy[5];
	private boolean[] booleanEnemyShots = new boolean[5]; 
	
	public GameField() {
		setBackground(Color.black);
		myTank.loadImages();
		enemy.loadImages();
		newShot.loadImages();
		for (int i = 0; i< myShots.length; i++){
			Shot t = new Shot();
			myShots[i] = t;
		}
		for (Shot m : myShots){
			m.loadImages();
		}
		for (boolean b : booleanShots) {
			b = false;
		}
		//enemy
		for (int i = 0; i< enemyShots.length; i++){
			ShotEnemy t = new ShotEnemy();
			enemyShots[i] = t;
		}
		for (ShotEnemy m : enemyShots){
			m.loadImages();
		}
		for (boolean b : booleanEnemyShots) {
			b = false;
		}
		initGame();
		addKeyListener(new FieldKeyListener());
		setFocusable(true);
		  
	}
	
	public void creatShot() {
		
	}
	
	public void initGame() {
		//Устанавливаю начальные координаты моего танка
		myTank.setX(32*6);
		myTank.setY(32*8);
		myTank.setDegree(0);
		// set an enemy
		enemy.setDegree(0);
		enemy.setX(32*5);
		enemy.setY(32*5);
		
		newShot.setX(-32*ALL_DOTS);
		newShot.setY(-32*ALL_DOTS);
		
		for (Shot m : myShots){
			m.setX(-32*ALL_DOTS);
			m.setY(-32*ALL_DOTS);
		}
		//enemy shots
		for (ShotEnemy m : enemyShots){
			m.setX(-32*ALL_DOTS);
			m.setY(-32*ALL_DOTS);
		}
		//create a timer
		timer = new Timer(250,this);
		timer.start();
	}
	// проверка на столкновение для моего танка
	public void checkMyTankCollisions() {
		if (myTank.getX() < 0) {
			myTank.setX(0);
		}
		if (myTank.getX() > (SIZE-myTank.getDotSize())) {
			myTank.setX(SIZE-myTank.getDotSize());
		}
		if (myTank.getY() < 0) {
			myTank.setY(0);
			//inGame = false;
		}
		if (myTank.getY() > (SIZE-myTank.getDotSize())) {
			myTank.setY(SIZE-myTank.getDotSize());
		}
	}
	
	public void checkMyShotCollisions() {
		for (int i=0; i < booleanShots.length;i++) {
			
		
			if (myShots[i].getX() < 0) {
				myShots[i].setX(-32*ALL_DOTS);
				myShots[i].setY(-32*ALL_DOTS);
				booleanShots[i] = false;
			}
			if (myShots[i].getX() > (SIZE-myShots[i].getDotSize())) {
				myShots[i].setX(-32*ALL_DOTS);
				myShots[i].setY(-32*ALL_DOTS);
				booleanShots[i] = false;
			}
			if (myShots[i].getY() < 0) {
				myShots[i].setX(-32*ALL_DOTS);
				myShots[i].setY(-32*ALL_DOTS);
				booleanShots[i] = false;
			}
			if (myShots[i].getY() > (SIZE-myShots[i].getDotSize())) {
				myShots[i].setX(-32*ALL_DOTS);
				myShots[i].setY(-32*ALL_DOTS);
				booleanShots[i] = false;
			}
		}
	}
	
	public void checkEnemyShotCollisions() {
		for (int i=0; i < booleanEnemyShots.length;i++) {
			
		
			if (enemyShots[i].getX() < 0) {
				enemyShots[i].setX(-32*ALL_DOTS);
				enemyShots[i].setY(-32*ALL_DOTS);
				booleanEnemyShots[i] = false;
			}
			if (enemyShots[i].getX() > (SIZE-enemyShots[i].getDotSize())) {
				enemyShots[i].setX(-32*ALL_DOTS);
				enemyShots[i].setY(-32*ALL_DOTS);
				booleanEnemyShots[i] = false;
			}
			if (enemyShots[i].getY() < 0) {
				enemyShots[i].setX(-32*ALL_DOTS);
				enemyShots[i].setY(-32*ALL_DOTS);
				booleanEnemyShots[i] = false;
			}
			if (enemyShots[i].getY() > (SIZE-enemyShots[i].getDotSize())) {
				enemyShots[i].setX(-32*ALL_DOTS);
				enemyShots[i].setY(-32*ALL_DOTS);
				booleanEnemyShots[i] = false;
			}
		}
	}
	
	// проверка на столкновение Enemy танка
	public void checkEnemyCollisions() {
		if (enemy.getX() < 0) {
			enemy.setX(0);
		}
		if (enemy.getX() > (SIZE-enemy.getDotSize())) {
			enemy.setX(SIZE-enemy.getDotSize());
		}
		if (enemy.getY() < 0) {
			enemy.setY(0);
			//inGame = false;
		}
		if (enemy.getY() > (SIZE-enemy.getDotSize())) {
			enemy.setY(SIZE-enemy.getDotSize());
		}
		
		 // если наедут друг на друга
		if (myTank.getX() == enemy.getX() & myTank.getY() == enemy.getY()) {
			
		}
	}
	// shot 
	public void checkEnemy() {
		if (newShot.getX() == enemy.getX() & newShot.getY() == enemy.getY()) {
			enemy.setX(new Random().nextInt(ALL_DOTS)*enemy.getDotSize());
			enemy.setY(new Random().nextInt(ALL_DOTS)*enemy.getDotSize());
			newShot.setX(-32*ALL_DOTS);
			newShot.setY(-32*ALL_DOTS);
			}
		
			for (int i=0; i < booleanShots.length;i++) {	
				if (booleanShots[i] == true) {
					if ((myShots[i].getX() == enemy.getX())& (myShots[i].getY() == enemy.getY())) {				
						enemy.setX(new Random().nextInt(ALL_DOTS)*enemy.getDotSize());
						enemy.setY(new Random().nextInt(ALL_DOTS)*enemy.getDotSize());
					
						myShots[i].setX(-32*ALL_DOTS);
						myShots[i].setY(-32*ALL_DOTS);
						booleanShots[i] = false;
						break;
					}
				}
			}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(inGame) {
			checkMyTankCollisions();
			checkEnemyCollisions();
			checkMyShotCollisions();
			checkEnemyShotCollisions();
			// одиночный мой выстрел
			newShot.moveShot();
			// мой танк стреляет
			for (int i=0; i < booleanShots.length;i++) {
				if (booleanShots[i] == true) {
					myShots[i].moveShot();
				}
				else {
					myShots[i].setX(-32*ALL_DOTS);
					myShots[i].setY(-32*ALL_DOTS);
				}
			}
			// стреляет враг
			for (int i=0; i < booleanEnemyShots.length;i++) {
				if (booleanEnemyShots[i] == true) {
					enemyShots[i].moveShot();
				}
				else {
					enemyShots[i].setX(-32*ALL_DOTS);
					enemyShots[i].setY(-32*ALL_DOTS);
				}
			}
			
			checkEnemy();
			enemy.moveTank();
			enemyShot();
			myTank.moveTank();
			
		}
		repaint();
	}

	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		if(inGame) {
			// enemy's tank
			for (int i=0; i < booleanEnemyShots.length;i++) {
				if (booleanEnemyShots[i] == true) {
					g2d.drawImage(enemyShots[i].getImage(), enemyShots[i].getX(), enemyShots[i].getY(), this);
				}
			}
			
			// мой танк
			for (int i=0; i < booleanShots.length;i++) {
				if (booleanShots[i] == true) {
					g2d.drawImage(myShots[i].getImage(), myShots[i].getX(), myShots[i].getY(), this);
				}
			}

			g2d.drawImage(newShot.getImage(), newShot.getX(), newShot.getY(), this);
		
			// ВРащение и показ Врага
//			g2d.drawImage(enemy.getImage(), enemy.getX(), enemy.getY(), this);
			if(enemy.leftEq())
			{
				g2d.drawImage(enemy.getImageLeft(), enemy.getX(), enemy.getY(), this);
				enemy.stop();
			}
			else if(enemy.rightEq())
			{
				g2d.drawImage(enemy.getImageRight(), enemy.getX(), enemy.getY(), this);
				enemy.stop();
			}
			else if(enemy.downEq())
			{
				g2d.drawImage(enemy.getImageDown(), enemy.getX(), enemy.getY(), this);
				enemy.stop();
			}
			else {
				g2d.drawImage(enemy.getImage(), enemy.getX(), enemy.getY(), this);
				enemy.stop();
			}
			
			// Вращение и показ моего танка
			if(myTank.leftEq())
			{
				g2d.drawImage(myTank.getImageLeft(), myTank.getX(), myTank.getY(), this);
				myTank.stop();
			}
			else if(myTank.rightEq())
			{
				g2d.drawImage(myTank.getImageRight(), myTank.getX(), myTank.getY(), this);
				myTank.stop();
			}
			else if(myTank.downEq())
			{
				g2d.drawImage(myTank.getImageDown(), myTank.getX(), myTank.getY(), this);
				myTank.stop();
			}
			else {
				//	g2d.rotate(Math.toRadians(myTank.getDegree()), myTank.getX() +16, myTank.getY()+16);
				g2d.drawImage(myTank.getImage(), myTank.getX(), myTank.getY(), this);
				myTank.stop();
			}
			
		}
	}
	public void enemyShot() {
			for (int i=0; i < booleanEnemyShots.length;i++) {
				enemy.getShotTF();
				if (enemy.getShotTF() == true) {
					if (booleanEnemyShots[i] == false) {
						enemyShots[i].sideR(enemy.shot());
						enemyShots[i].setX(enemy.getX());
						enemyShots[i].setY(enemy.getY());
						booleanEnemyShots[i] = true;
						break;
					}
			}
		}
	}
	
	public void whoShot() {
		for (int i=0; i < booleanShots.length;i++) {
			if (booleanShots[i] == false) {
				myShots[i].sideR(myTank.shot());
				myShots[i].setX(myTank.getX());
				myShots[i].setY(myTank.getY());
				booleanShots[i] = true;
				break;
			}
		}
	}
	
	// управлние моим танком
	class FieldKeyListener extends KeyAdapter{
		
		@Override
		public void keyPressed(KeyEvent arg0) {
			// TODO Auto-generated method stub
			super.keyPressed(arg0);
			int key = arg0.getKeyCode();
			if(key == KeyEvent.VK_LEFT) {
				myTank.leftTrue();
			}
			if(key == KeyEvent.VK_RIGHT) {
				myTank.rightTrue();
			}
			if(key == KeyEvent.VK_UP) {
				myTank.upTrue();
			}
			if(key == KeyEvent.VK_DOWN) {
				myTank.downTrue();
			}
			if(key == KeyEvent.VK_W) {
				newShot.sideR(myTank.shot());
				newShot.setX(myTank.getX());
				newShot.setY(myTank.getY());
			}
			if(key == KeyEvent.VK_SPACE) {
				whoShot();
			}
		}
		
	}
	
}