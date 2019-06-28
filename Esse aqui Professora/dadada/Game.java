import java.awt.BorderLayout;

import javax.swing.*;

public class Game extends JPanel{
	
	private JPanel informacoes;
	private JLabel score, highscore, tempo;
	
	private JPanel tabuleiro;
	private JPanel[] quadrados = new JPanel[16];
	
	public Game() {
		
		setLayout(new BorderLayout());
		
		informacoes = new JPanel();
		highscore = new JLabel("<html>HighScore:<br/>500<html/>");
		score = new JLabel("<html>Score:<br/>99<html/>");
		tempo = new JLabel("<html>Tempo (segundos):<br/>30<html/>");
		
		informacoes.add(highscore);
		informacoes.add(score);
		informacoes.add(tempo);
		
		add(informacoes, BorderLayout.NORTH);
		
		

	}
}
