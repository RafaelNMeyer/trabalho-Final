import javax.swing.JFrame;

public class Main {

	public static void main(String[] args) {
		GameManager game = new GameManager();
		game.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		game.setSize(640, 960); // set frame size
		game.setVisible(true);// display frame
	} //
}
