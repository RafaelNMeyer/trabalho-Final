package dadada;

import javax.swing.*;

public class Tela extends JFrame{
	
	private Menu menu;
	private Game jogo;
	private Historico historico;
	private ImageIcon fundo = new  ImageIcon("//home//100000000901561//eclipse-workspace//Final//src//cf0631051d0accaa29fecffd78c661e9.png");
	private int selecionador;
	
	public Tela() {
		
		//this.menu = menu;
		//menu = new Menu();
		jogo = new Game();
		historico = new Historico();
		setContentPane(menu);
        //selecionador = menu.getAtivaMenu();		
		
	}	

	public void telaAtual(int sel) {
		System.out.println(sel);
		switch (sel) {
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
	public Menu getMenu() {
		return menu;
	}
	public void setMenu(Menu menu) {
		this.menu = menu;
	}
	public Game getJogo() {
		return jogo;
	}
	public void setJogo(Game jogo) {
		this.jogo = jogo;
	}
	public Historico getHistorico() {
		return historico;
	}
	public void setHistorico(Historico historico) {
		this.historico = historico;
	}

}
