package dadada;

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
	public static int ativaMenu;


	public Menu(Tela tela) {

		setLayout(new BorderLayout());
		painelBotoes = new JPanel();
		painelBotoes.setPreferredSize(new Dimension(640, 500));
		painelBotoes.setLayout(new GridLayout(2,1,5,5));
		
		jogar = new JButton("Jogar");
		painelBotoes.add(jogar);
		tutorial = new JButton("Tutorial");
		painelBotoes.add(tutorial);
		
		add(new JPanel(), BorderLayout.NORTH);
		add(new JPanel(), BorderLayout.SOUTH);
		add(painelBotoes, BorderLayout.CENTER);
		
		jogar.addActionListener(new ActionListener() {
		
			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getActionCommand().equals("Jogar"))
					
					ativaMenu = 2;
					tela.setContentPane(new Game());
				System.out.println("ativa menu "+ativaMenu);
				//retornaativaMenu(2);					
			}
		});
		
		tutorial.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getActionCommand().equals("Tutorial"))
					JOptionPane.showMessageDialog(null, "Clique o mais rapido possivel nos quadrados pretos!!!!!!!!");
			}
		});
		

	}
	
	public static int retornaAtivaMenu(int sel) {
		return sel;
	}

	public int getAtivaMenu() {
		return ativaMenu;
	}

	public void setAtivaMenu(int AtivaMenu) {
		this.ativaMenu = ativaMenu;
	}
	
}
