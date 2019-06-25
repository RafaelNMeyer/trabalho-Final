package dadada;

import javax.swing.JFrame;

public class Main {

	public static void main(String[] args) {
		
		
		Tela game = new Tela();
		Menu menu = new Menu(game);
		
		if (game.getMenu().getAtivaMenu() == 0)
			game.telaAtual(menu.getAtivaMenu());
		//game.telaAtual(2);
		

		System.out.println(	menu.ativaMenu+"asoifdjsa");
		game.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		game.setSize(640, 960); // set frame size
		game.setVisible(true);// display frame
	} //
}
