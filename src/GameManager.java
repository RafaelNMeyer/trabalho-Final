import javax.swing.*;

public class GameManager extends JFrame{
	
	private Menu menu;
	private Game jogo;
	private Historico historico;
	private ImageIcon fundo = new  ImageIcon("//home//100000000901561//eclipse-workspace//Final//src//cf0631051d0accaa29fecffd78c661e9.png");
	private int selecionador;
	
	public GameManager() {
		
		menu = new Menu();
		
		
        add(menu);
        //remove(menu);
        selecionador = menu.getSelecionador();
		switch (selecionador) {
		case 1:
	        setContentPane(menu);
	        break;
		case 2:
	        setContentPane(jogo);
	        break;
		case 3:
	        setContentPane(historico);
	        break;
	    default:
	    	setContentPane(menu);
		}

		
		
	}	
	

}
