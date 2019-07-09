
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;

import javax.swing.*;
import javax.swing.border.Border;

public class Menu extends JPanel {

	private JButton jogar;
	private JButton tutorial;
	private JPanel painelBotoes;

	public Menu(Tela tela) {

		setLayout(new BorderLayout());
		
		JPanel centralizaImg = new JPanel();
		centralizaImg.setBackground(Color.WHITE);
		
		Icon hit = new ImageIcon( getClass().getResource("clique.jpg") );
		JLabel planoDeFundo = new JLabel();
		planoDeFundo.setIcon(hit);
		centralizaImg.add(planoDeFundo);
		add(centralizaImg, BorderLayout.CENTER);
		
		JPanel alinharBotaoJogar = new JPanel();
		alinharBotaoJogar.setBackground(Color.WHITE);
		JPanel alinharBotaoTutorial = new JPanel();
		alinharBotaoTutorial.setBackground(Color.WHITE);
		jogar = new JButton("Jogar");
		alinharBotaoJogar.add(jogar);
		tutorial = new JButton("Tutorial");
		alinharBotaoTutorial.add(tutorial);
		
		painelBotoes = new JPanel();
		painelBotoes.setLayout(new BorderLayout());
		painelBotoes.add(alinharBotaoJogar, BorderLayout.NORTH);
		painelBotoes.add(alinharBotaoTutorial, BorderLayout.SOUTH);

		add(painelBotoes, BorderLayout.SOUTH);

		jogar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getActionCommand().equals("Jogar")) {
					tela.telaAtual(2);
					tela.setSize(640,700);
				}
			}
		});

		tutorial.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getActionCommand().equals("Tutorial"))
					JOptionPane.showMessageDialog(null, "Clique o mais rapido possivel nos quadrados pretos!\n"
							+ "Se clicar num quadrado BRANCO, você perde!");
			}
		});

	}
}