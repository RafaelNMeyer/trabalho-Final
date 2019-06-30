
import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;

public class BotaoTabuleiro extends JButton {
	
	public BotaoTabuleiro(Game jogo, Color cor) {
		this.addMouseListener(new EfeitoBotao(this, jogo));
		this.setBorderPainted(false);
		this.setBackground(cor);
	}
	
	public class EfeitoBotao implements MouseListener {
		
		private BotaoTabuleiro botao;
		private Game jogo; 
		
		public EfeitoBotao (BotaoTabuleiro b, Game g ) {
			jogo = g;
			botao = b;
		}
		
		@Override
		public void mouseClicked(MouseEvent e) { }

		@Override
		public void mouseEntered(MouseEvent e) {
			botao.setCursor(new Cursor(Cursor.HAND_CURSOR));
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
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
				jogo.getTempoJogo().cancelaTempoEmbaralhar();
				JOptionPane.showMessageDialog(null,
						"Você clicou em um quadrado BRANCO!\nJogo encerrado!",
						"GAME OVER", JOptionPane.ERROR_MESSAGE);
			}
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			
		}
		
	}

}
