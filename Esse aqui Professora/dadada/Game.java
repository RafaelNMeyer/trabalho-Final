import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;

public class Game extends JPanel{
	
	private Contador tempoJogo;
	
	private JPanel informacoes;
	private JLabel mostraScore, mostraHighscore, mostraTempo;
	
	private JPanel tabuleiro;
	private JButton[] quadrados = new JButton[16];
	
	public Game() {
		
		setLayout(new BorderLayout());
		
		tempoJogo = new Contador(this);
		informacoes = new JPanel();
		mostraHighscore = new JLabel("<html>HighScore:<br/>500<html/>");
		mostraScore = new JLabel("<html>Score:<br/>99<html/>");
		mostraTempo = new JLabel("<html>Tempo (segundos):<br/>30<html/>");
		
		informacoes.add(mostraHighscore);
		informacoes.add(mostraScore);
		informacoes.add(mostraTempo);
		add(informacoes, BorderLayout.NORTH);
		
		tabuleiro = new JPanel();
		add(tabuleiro, BorderLayout.CENTER);
		tabuleiro.setLayout(new GridLayout(4,4,2,2));
		tabuleiro.addMouseListener(new AcaoTabuleiro(tabuleiro));
		
		
		for (int i = 0; i < quadrados.length; i++)
		{
			quadrados[i] = new JButton();
			quadrados[i].setBorderPainted(false);
			tabuleiro.add(quadrados[i]);
		}

	}
	public void atualizaLabelTempo () {
		mostraTempo.setText("<html>Tempo (segundos):<br/>"+tempoJogo.getTempo()+"<html/>");
	}
	public Contador getTempoJogo() {
		return tempoJogo;
	}
	public void setTempoJogo(Contador tempoJogo) {
		this.tempoJogo = tempoJogo;
	}
		
	
}
