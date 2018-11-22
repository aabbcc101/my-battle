package battle2;

import javax.swing.JFrame;

public class MainWindow extends JFrame {
	
	public MainWindow() {
		setTitle("Battle");
//		setSize(640,665);
		setSize(320,345);
	//	setLocation(400,400);
		setLocation(200,200);
		add(new GameField());
		setVisible(true);
	}	
	public static void main(String[] arg) {
		MainWindow mw = new MainWindow();
	}

}
