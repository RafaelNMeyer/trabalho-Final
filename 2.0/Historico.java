
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

public class Historico extends JPanel{
	
	private JButton jogarNovamente;
	private JButton retornarMenu;
	private JPanel central, norte, sul;
	private JLabel mostraData;
	private JLabel mostraPontuacao;
	private JLabel mostraHistoricoPontuacao;
	private ArrayList<ConteudoSerializable> historicoConteudo = new ArrayList<ConteudoSerializable>(); 
	private ConteudoSerializable conteudo;
	
	
	
	public Historico(Game jogo,Tela tela) {
		
		setLayout(new BorderLayout());
		
		norte = new JPanel();
		mostraPontuacao = new JLabel("");
		norte.add(mostraPontuacao);
		mostraPontuacao.setText("<html>Sua Pontuação:                                   "+jogo.getScore()+"<html/>");
		mostraPontuacao.setFont(mostraPontuacao.getFont().deriveFont(30.0f));
		add(norte, BorderLayout.NORTH);
		
		central = new JPanel();
		mostraData = new JLabel("<html>Data:<br/>04/07/2019<html/>");
		mostraHistoricoPontuacao = new JLabel("<html>Pontuação:<br/>50<html/>");
		add(central, BorderLayout.CENTER);
		
		sul = new JPanel();
		jogarNovamente = new JButton("Jogar novamente");
		jogarNovamente.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getActionCommand().equalsIgnoreCase(jogarNovamente.getText())) {
					tela.telaAtual(2);
					tela.setSize(640,700);
				}
			}
		});
		sul.add(jogarNovamente);
		
		retornarMenu = new JButton("Retornar ao menu");
		retornarMenu.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getActionCommand().equalsIgnoreCase(retornarMenu.getText())) {
					tela.telaAtual(1);
					tela.setSize(640,700);
				}
			}
		});
		sul.add(retornarMenu);
		add(sul, BorderLayout.SOUTH);
		
		historicoConteudo.add(conteudo.setPontuacao(jogo.getScore());
		
		
	}

}
