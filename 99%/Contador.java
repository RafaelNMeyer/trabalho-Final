import java.util.Timer;
import java.util.TimerTask;

public class Contador 
{
	private int tempo;
	private Game jogo;
	Timer timerJogo, timerEmbaralhador;
	
	public Contador(Game g) {
		jogo = g;
	}
	
	public Contador() {}
	
	/**
	 * metodo que faz contagem regressiva em segundos
	 * @param t
	 */
	public void iniciarContagem (int t){
		int intervalo = 1000;
		int delay = 0;
		tempo = t;
		timerJogo = new Timer();
		timerJogo.scheduleAtFixedRate(new TimerTask() {
			public void run() {
				if (tempo > 0) {
					tempo--;
					if (t >= 30)
						jogo.atualizaLabelTempo();
					else if (t == 4) { // condi��o quando o m�todo � chamado pelo contador countdown(3, 2, 1 come�ar)
						jogo.atualizaLabelCowntdown();
						if (tempo == 0) {
							jogo.remove(jogo.getPainelCountdown());
							jogo.iniciarJogo();
							jogo.atualizaLabelTempo();
						}
					}
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
        timerEmbaralhador = new Timer();
        timerEmbaralhador.scheduleAtFixedRate(timerTask ,delay, intervalo);
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
        timerEmbaralhador.cancel();
        timerEmbaralhador = new Timer();
        timerEmbaralhador.scheduleAtFixedRate(timerTask ,delay, intervalo);
	}
	
	public void cancelaTempoEmbaralhar() {
		timerEmbaralhador.cancel();
	}
	
	public void pararTempoJogo() {
		timerJogo.cancel();
	}

	public int getTempo() {
		return tempo;
	}

	public void setTempo(int tempo) {
		this.tempo = tempo;
	}
}
