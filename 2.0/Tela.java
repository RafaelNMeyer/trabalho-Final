import javax.swing.*;

public class Tela extends JFrame {

	private Menu menu;
	private Game jogo;
	private Historico historico;
	private ImageIcon fundo = new ImageIcon(
			"//home//100000000901561//eclipse-workspace//Final//src//cf0631051d0accaa29fecffd78c661e9.png");
	private int selecionador;

	public Tela() {

		menu = new Menu(this);
		//jogo = new Game(this);
		//historico = new Historico(this);
		add(menu);
	}
	
	/**
	 * m�todo que controla qual painel estara visivel no frame
	 * @param sel
	 */
	public void telaAtual(int sel) {
		switch (sel) {
		case 1:
			setContentPane(menu);
			break;
		case 2:
			Game jogo = new Game(this);
			this.jogo=jogo;
			setContentPane(jogo);
			jogo.getTempoJogo().iniciarContagem(31);
			jogo.getTempoJogo().iniciaTempoEmbaralhar();
			jogo.atualizaLabelTempo();
			break;
		case 3:
			Historico historico = new Historico(this.jogo,this);
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

/*	public Game getJogo() {
		return jogo;
	}

	public void setJogo(Game jogo) {
		this.jogo = jogo;
	}*/

	public Historico getHistorico() {
		return historico;
	}

	public void setHistorico(Historico historico) {
		this.historico = historico;
	}
	
	
}