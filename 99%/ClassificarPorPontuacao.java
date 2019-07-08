import java.util.Comparator;

class ClassificarPorPontuacao implements Comparator<ConteudoSerializavel> 
{ 
	@Override
	public int compare(ConteudoSerializavel a, ConteudoSerializavel b) {
		
		return b.getPontuacao() - a.getPontuacao(); 
	} 
}
