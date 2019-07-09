import javax.swing.*;

public class Tela extends JFrame {

	private Menu menu;
	private Game jogo;
	private Historico historico;
	private ImageIcon fundo = new ImageIcon(
			"//home//100000000901561//eclipse-workspace//Final//src//cf0631051d0accaa29fecffd78c661e9.png");

	public Tela() {
		
		super("Fastest clicker");
		menu = new Menu(this);
		add(menu);
		
	}
	
	/**
	 * método que controla qual painel estara visivel no frame
	 * @param sel
	 */
	public void telaAtual(int sel) {
		switch (sel) {
		case 1:
			setContentPane(menu);
			break;
		case 2:
			jogo = new Game(this);
			setContentPane(jogo);
			jogo.iniciarCountdown();

			break;
		case 3:
			jogo.atualizarHistorico();
			historico = new Historico(this.jogo, this);			
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