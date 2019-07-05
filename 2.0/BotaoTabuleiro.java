
import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;

public class BotaoTabuleiro extends JButton {
	
	public BotaoTabuleiro(Game jogo, Color cor, Tela tela) {
		this.addMouseListener(new EfeitoBotao(this, jogo, tela));
		this.setBorderPainted(false);
		this.setBackground(cor);
		
	}
	
	public class EfeitoBotao implements MouseListener {
		
		private BotaoTabuleiro botao;
		private Game jogo;
		private Tela tela;
		
		public EfeitoBotao (BotaoTabuleiro b, Game g, Tela t ) {
			jogo = g;
			botao = b;
			tela = t;
		}
		
		@Override
		public void mouseClicked(MouseEvent e) { }

		@Override
		public void mouseEntered(MouseEvent e) {
			botao.setCursor(new Cursor(Cursor.HAND_CURSOR));
			if (botao.getBackground() == Color.BLACK) {
				botao.setBackground(Color.BLACK);
			}
			else 
				botao.setBackground(Color.WHITE);

		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			botao.setBorderPainted(false);
			int pontos = jogo.getScore();
			if (botao.getBackground() == Color.BLACK) {
			if (jogo.getTempoJogo().getTempo() <= 30) {
				jogo.getTempoJogo().reiniciaTempoEmbaralhar(2000, 2000);
				jogo.setScore(pontos + 1);
			}
			if (jogo.getTempoJogo().getTempo() <= 20) {
				jogo.getTempoJogo().reiniciaTempoEmbaralhar(1000, 1000);
				jogo.setScore(pontos + 2);
			}
			if (jogo.getTempoJogo().getTempo() <= 10) {
				jogo.getTempoJogo().reiniciaTempoEmbaralhar(500, 500);
				jogo.setScore(pontos + 4);
			}
			if (jogo.getTempoJogo().getTempo() <= 5) {
				jogo.getTempoJogo().reiniciaTempoEmbaralhar(200, 200);
				jogo.setScore(pontos + 10);
			}								
				jogo.atualizaLabelScore();
				jogo.distribuirTabuleiro();
			}
			else {
				botao.setBackground(Color.WHITE);
				botao.setBorderPainted(false);
				jogo.getTempoJogo().cancelaTempoEmbaralhar();
				jogo.getTempoJogo().pararTempoJogo();
				/*JOptionPane.showMessageDialog(null,
						"Voc� clicou em um quadrado BRANCO!\nJogo encerrado!\n"
						+ "Sua pontua��o: "+jogo.getScore(),
						"GAME OVER", JOptionPane.ERROR_MESSAGE);*/
				
				tela.telaAtual(3);
				tela.setSize(640, 650);
				tela.setSize(640, 700);
			}
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			
		}
		
	}

}
