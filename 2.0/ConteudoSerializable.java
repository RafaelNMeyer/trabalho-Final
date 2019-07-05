
import java.io.Serializable;
import java.util.Date;



public class ConteudoSerializable implements Serializable
{
	private Date dataDaJogada;
	private int pontuacao; // length da string do pangrama
	

// no-argument constructor calls other constructor with default values
public ConteudoSerializable() 
{
} // end no-argument AccountRecordSerializable constructor

// four-argument constructor initializes a record
public ConteudoSerializable( Date dataDaJogada, int pontuacao)
{
	
	setDataDaJogada(dataDaJogada);
	setPontuacao(pontuacao);

} // end four-argument AccountRecordSerializable constructor

public Date getDataDaJogada() {
	return dataDaJogada;
}

public void setDataDaJogada(Date dataDaJogada) {
	this.dataDaJogada = dataDaJogada;
}

public int getPontuacao() {
	return pontuacao;
}

public void setPontuacao(int pontuacao) {
	this.pontuacao = pontuacao;
}


}
