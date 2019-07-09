import java.io.Serializable;

public class ConteudoSerializavel implements Serializable {
	private String dataDaJogada;
	private int pontuacao;

	// no-argument constructor calls other constructor with default values
	public ConteudoSerializavel() {
	}

	// four-argument constructor initializes a record
	public ConteudoSerializavel(String dataDaJogada, int pontuacao) {

		setDataDaJogada(dataDaJogada);
		setPontuacao(pontuacao);

	} // end four-argument AccountRecordSerializable constructor

	public String getDataDaJogada() {
		return dataDaJogada;
	}

	public void setDataDaJogada(String dataDaJogada) {
		this.dataDaJogada = dataDaJogada;
	}

	public int getPontuacao() {
		return pontuacao;
	}

	public void setPontuacao(int pontuacao) {
		this.pontuacao = pontuacao;
	}

}
