import java.util.Timer;
import java.util.TimerTask;

public class Contador 
{
	private int tempo;
	private Game jogo;
	Timer timer;
	
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
		jogo.getTempoJogo().iniciaTempoEmbaralhar();
		timer = new Timer();
		timer.scheduleAtFixedRate(new TimerTask() {
			public void run() {
				if (tempo > 0) {
					tempo--;
					jogo.atualizaLabelTempo();
				}
			}
		},delay, intervalo);	
	}
	
	public void iniciaTempoEmbaralhar (){
		int intervalo = 3000;
		int delay = 3000;
		TimerTask timerTask = new TimerTask() {

            @Override
            public void run() {
            	jogo.distribuirTabuleiro();
            }
        };
        timer = new Timer();
        timer.scheduleAtFixedRate(timerTask ,delay, intervalo);
	}
	
	public void reiniciaTempoEmbaralhar(int i, int d) {
		int intervalo = i;
		int delay = d;
        TimerTask timerTask = new TimerTask() {

            @Override
            public void run() {
            	jogo.distribuirTabuleiro();
            }
        };
        timer.cancel();
        timer = new Timer();
        timer.scheduleAtFixedRate(timerTask ,delay, intervalo);
	}
	
	public void cancelaTempoEmbaralhar() {
		timer.cancel();
	}

	public int getTempo() {
		return tempo;
	}

	public void setTempo(int tempo) {
		this.tempo = tempo;
	}
}
