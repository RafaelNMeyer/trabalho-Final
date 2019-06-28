import java.util.Timer;
import java.util.TimerTask;

public class Contador 
{
	private Timer timer1;
	private int tempo;
	private Game jogo;
	
	public Contador(Game g) {
		jogo = g;
	}
	
	/**
	 * metodo que faz contagem regressiva em segundos
	 * @param t
	 */
	public void iniciarContagem (int t){
		int intervalo = 1000;
		int delay = 0;
		tempo = t;
		timer1 = new Timer();
		timer1.scheduleAtFixedRate(new TimerTask() {
			public void run() {
				if (tempo > 0) {
					tempo--;
				System.out.println(tempo);
				jogo.atualizaLabelTempo();
				}
			}
		},delay, intervalo);	
	}

	public int getTempo() {
		return tempo;
	}

	public void setTempo(int tempo) {
		this.tempo = tempo;
	}
}
