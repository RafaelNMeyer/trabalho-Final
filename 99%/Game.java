import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import javax.swing.*;

public class Game extends JPanel {
	
	private SequentialFileManager fileManager;
	private ArrayList<ConteudoSerializavel> historicoJogadas;
	
	private Tela tela;
	private Contador tempoJogo;
	private String dataDoJogo;

	private JPanel informacoes;
	private JLabel mostraScore, mostraHighscore, mostraTempo;
	private int score, highScore;
	private JPanel tabuleiro;
	private BotaoTabuleiro[] quadrados = new BotaoTabuleiro[16];

	private JPanel painelCountdown;
	private Contador tres2um;
	private JLabel mostraCountdown, mostraMsgCountdown;

	public Game(Tela telaMae) {
		
		tela = telaMae;
		setLayout(new BorderLayout());
		
		fileManager = new SequentialFileManager(); // classe que administra as operacoes de criar e modificar o file
		historicoJogadas = new ArrayList<ConteudoSerializavel>();
		lerHistorico();
		
		// pega a data da jogada no momento em que inicia o jogo ! ( e converte p/ string)
		LocalDateTime myDateObj = LocalDateTime.now();
		DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		dataDoJogo = myDateObj.format(myFormatObj);

		painelCountdown = new JPanel();
		tres2um = new Contador(this);
		mostraCountdown = new JLabel("");
		mostraCountdown.setFont(mostraCountdown.getFont().deriveFont(200.0f));
		mostraMsgCountdown = new JLabel("PREPARE-SE!");
		mostraMsgCountdown.setFont(mostraMsgCountdown.getFont().deriveFont(64.0f));
		painelCountdown.add(mostraCountdown);

		tempoJogo = new Contador(this);
		
		highScore = buscarHighScore();
		mostraHighscore = new JLabel("<html>HighScore:<br/>"+highScore+"<html/>");
		mostraHighscore.setFont(mostraHighscore.getFont().deriveFont(20.0f));
		mostraScore = new JLabel("<html>Score:<br/>0<html/>");
		mostraScore.setFont(mostraScore.getFont().deriveFont(20.0f));
		mostraTempo = new JLabel("<html>Tempo (segundos):<br/><html/>");
		mostraTempo.setFont(mostraTempo.getFont().deriveFont(20.0f));

		informacoes = new JPanel();
		informacoes.setLayout(new GridLayout(1, 3));
		informacoes.add(mostraHighscore);
		informacoes.add(mostraScore);
		informacoes.add(mostraTempo);

		tabuleiro = new JPanel();
		tabuleiro.setLayout(new GridLayout(4, 4, 2, 2));

		/*
		 * logica para criar tabuleiro com quatro botoes pretos e o resto dos botoes
		 * brancos, de forma aleatoria
		 */
		int quantPretos = 0;
		int[] idBotoesPretos = this.gerarAleatorios();
		for (int i = 0; i < quadrados.length; i++) {
			if (quantPretos < 4) {
				quadrados[i] = new BotaoTabuleiro(this, Color.WHITE, tela);
				for (int j = 0; j < idBotoesPretos.length; j++)
					if (i == idBotoesPretos[j]) {
						quadrados[i].setBackground(Color.BLACK);
						quantPretos++;
					}
			} else
				quadrados[i] = new BotaoTabuleiro(this, Color.WHITE, tela);
			tabuleiro.add(quadrados[i]);
		}
	}

	/**
	 * metodo que gera 4 números aleatorios distintos de 0 a 15 (para posicionar os
	 * quadados pretos)
	 * 
	 * @return array de 4 ints
	 */
	public int[] gerarAleatorios() {
		Random ran = new Random();
		boolean temQuatro = false;
		int quantPretos = 4;
		int idBotoesPretos[] = new int[4];
		while (!temQuatro) {
			temQuatro = true;
			while (quantPretos != 0) {
				idBotoesPretos[quantPretos - 1] = ran.nextInt(16);
				quantPretos--;
			}
			/*
			 * OBS esse bloco abaixo garante que os numeros serao DISTINTOS ou seja, se
			 * tirar pode ser que apareçam menos de 4 quadrados pretos pq daí podem aparecer
			 * numeros repetidos!
			 */
			for (int i = 0; i < idBotoesPretos.length; i++)
				for (int j = 0; j < idBotoesPretos.length; j++)
					if (i != j && idBotoesPretos[i] == idBotoesPretos[j]) {
						temQuatro = false;
						quantPretos = 4;
					}
			// até aqui para os numeros distintos
		}
		return idBotoesPretos;
	}

	/**
	 * metodo que distribui as cores dos botoes no tabuleiro
	 */
	public void distribuirTabuleiro() {
		int quantPretos = 0;
		int idBotoesPretos[] = this.gerarAleatorios();

		for (int i = 0; i < quadrados.length; i++) {
			if (quantPretos < 4) {
				quadrados[i].setBackground(Color.WHITE);
				for (int j = 0; j < idBotoesPretos.length; j++)
					if (i == idBotoesPretos[j]) {
						quadrados[i].setBackground(Color.BLACK);
						quantPretos++;
					}
			} else
				quadrados[i].setBackground(Color.WHITE);
		}
	}

	public void atualizaLabelCowntdown() {
		mostraCountdown.setText("<html>" + tres2um.getTempo() + "<html/>");
	}

	public void atualizaLabelScore() {
		mostraScore.setText("<html>Score:<br/>" + score + "<html/>");
	}

	public void atualizaLabelTempo() {
		mostraTempo.setText("<html>Tempo (segundos):<br/>" + tempoJogo.getTempo() + "<html/>");
		if (tempoJogo.getTempo() == 0) {
			mostraTempo.setText("<html>Tempo (segundos):<br/>" + tempoJogo.getTempo() + "<html/>");
			tela.telaAtual(3);
			 tela.setSize(640,701);
			 tela.setSize(640,700);
		}
	}

	public Contador getTempoJogo() {
		return tempoJogo;
	}

	public void setTempoJogo(Contador tempoJogo) {
		this.tempoJogo = tempoJogo;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public Contador getTres2um() {
		return tres2um;
	}

	public void setTres2um(Contador tres2um) {
		this.tres2um = tres2um;
	}

	public JPanel getPainelCountdown() {
		return painelCountdown;
	}

	public void setPainelCountdown(JPanel painelCountdown) {
		this.painelCountdown = painelCountdown;
	}
	
	public String getDataDoJogo() {
		return dataDoJogo;
	}

	public void setDataDoJogo(String dataDoJogo) {
		this.dataDoJogo = dataDoJogo;
	}

	public void iniciarCountdown() {
		JPanel alinhamento = new JPanel();
		alinhamento.setPreferredSize(new Dimension(640, 200));
		alinhamento.add(mostraMsgCountdown);
		this.add(alinhamento, BorderLayout.NORTH);
		this.add(painelCountdown, BorderLayout.CENTER);
		this.getTres2um().iniciarContagem(4);
	}

	public void iniciarJogo() {
		this.remove(mostraCountdown);
		this.add(informacoes, BorderLayout.NORTH);
		this.add(tabuleiro, BorderLayout.CENTER);
		this.getTempoJogo().iniciarContagem(31);
		this.getTempoJogo().iniciaTempoEmbaralhar();
	}
	
	public void lerHistorico() { 
		// logica para ler o conteudo do arquivo serializavel no início da execução do
		// programa
		fileManager.openFileOutput();
		fileManager.openFileInput();
		try {
			historicoJogadas = fileManager.readRecords();
		} catch (NullPointerException vazio) {
			// exceção para a primeira leitura do arquivo ( pois o arquivo estará vazio )
		}

		fileManager.closeFileInput();
		fileManager.closeFileOutput();
	}
	
	public void atualizarHistorico() { //(NAO ESTA SENDO UTILIZADO!)
		// Lógica para reescrever o arquivo serializavel com as ultimas informaçoes
		// obtidas da jogada mais recente
		fileManager.openFileOutput();
		fileManager.deleteFile(); // o deleteFile() tem o mesmo código do openFile, ou seja, serve apenas para
								// sobrescreve o mesmo file com um file vazio, "apagando" o conteudo do file
								// anterior

		// cria um objeto serializavel com as informações a respeito da frase digitada
		ConteudoSerializavel c = new ConteudoSerializavel(dataDoJogo, score);

		// adiciona o objeto serializado recem criado a lista de objetos serializaveis
		// resgatada do arquivo serializado
		historicoJogadas.add(c);
		Collections.sort( historicoJogadas, new ClassificarPorPontuacao() );
		if ( historicoJogadas.size() > 10 )
			historicoJogadas.remove(10);

		// registra no novo arquivo serializado a lista com todo o historico anterior
		// resgatado mais o objeto contendo a ultima tentativa
		fileManager.addRecords(historicoJogadas);
		fileManager.closeFileOutput();
	}
	
	public int buscarHighScore() {
		int maior = Integer.MIN_VALUE;
		if (!historicoJogadas.isEmpty())
			for (int i = 0; i < historicoJogadas.size(); i++) {
				if ( historicoJogadas.get(i).getPontuacao() > maior )
					maior = historicoJogadas.get(i).getPontuacao();
			}
		else
			maior = 0;
		return maior;
	}

	public ArrayList<ConteudoSerializavel> getHistoricoJogadas() {
		return historicoJogadas;
	}

	public void setHistoricoJogadas(ArrayList<ConteudoSerializavel> historicoJogadas) {
		this.historicoJogadas = historicoJogadas;
	}

}
