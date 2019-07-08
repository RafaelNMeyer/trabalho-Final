
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collections;
import javax.swing.*;

public class Historico extends JPanel{
	
	private Game jogo;
	private JButton jogarNovamente;
	private JButton retornarMenu;
	private JPanel central, norte, sul;
	private JLabel mostraHistoricoData;
	private JLabel mostraUltimaPontuacao;
	private JLabel mostraHistoricoPontuacao;
	private JLabel mostraTituloRanking;

	
	private String historicoDatas, historicoPontuacoes;
			
	public Historico(Game jogo,Tela tela) {
		this.jogo = jogo;
		setLayout(new BorderLayout());
		
		norte = new JPanel();
		norte.setPreferredSize(new Dimension(640, 125));
		mostraUltimaPontuacao = new JLabel("");
		norte.add(mostraUltimaPontuacao);
		mostraUltimaPontuacao.setText("<html>Sua pontuação:                                   "+jogo.getScore()+"<html/>");
		mostraUltimaPontuacao.setFont(mostraUltimaPontuacao.getFont().deriveFont(40.0f));
		add(norte, BorderLayout.NORTH);
		
		central = new JPanel();
		central.setLayout(new BorderLayout());
		JPanel alinharTituloRanking = new JPanel();
		mostraTituloRanking = new JLabel("Top 10:");
		alinharTituloRanking.add(mostraTituloRanking);
		mostraTituloRanking.setFont(mostraTituloRanking.getFont().deriveFont(25.0f));
		central.add(alinharTituloRanking, BorderLayout.NORTH);
		JPanel alinhar = new JPanel();
		alinhar.setLayout(new FlowLayout());
		mostraHistoricoData = new JLabel("");
		mostraHistoricoData.setFont(mostraHistoricoData.getFont().deriveFont(25.0f));
		mostraHistoricoPontuacao = new JLabel("");
		mostraHistoricoPontuacao.setFont(mostraHistoricoPontuacao.getFont().deriveFont(25.0f));
		carregarHistorico();
		alinhar.add(mostraHistoricoData);
		alinhar.add(mostraHistoricoPontuacao);
		central.add(alinhar, BorderLayout.CENTER);
		add(central, BorderLayout.CENTER);
		
		sul = new JPanel();
		sul.setPreferredSize(new Dimension(640, 50));
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
		
		
		carregarHistorico();
	}


	public void carregarHistorico() {
		if (jogo.getHistoricoJogadas().isEmpty()) {
			historicoDatas = "";
			historicoPontuacoes = "";
		} else {
			historicoDatas = ("<html><pre>");
			historicoPontuacoes = ("<html><pre>");
			Collections.sort( jogo.getHistoricoJogadas(), new ClassificarPorPontuacao() );
			for (int i = 0; i < jogo.getHistoricoJogadas().size(); i++) {
				if ( i > 9 )
					jogo.getHistoricoJogadas().remove(i);
				else {
					historicoDatas += (jogo.getHistoricoJogadas().get(i).getDataDaJogada()+"\t\n");
					historicoPontuacoes += (jogo.getHistoricoJogadas().get(i).getPontuacao()+"\n");
				}
			}
			historicoDatas += ("</pre></html>");
			historicoPontuacoes += ("</pre></html>");
		}
		mostraHistoricoData.setText(historicoDatas);
		mostraHistoricoPontuacao.setText(historicoPontuacoes);
	}
	
}
