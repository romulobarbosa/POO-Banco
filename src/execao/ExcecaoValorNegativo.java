package execao;
import geral.Utilitarios;

@SuppressWarnings("serial")
public class ExcecaoValorNegativo extends RuntimeException {
	private static Utilitarios u = new Utilitarios();

	public ExcecaoValorNegativo(String message) {
		super(message);
		// u.pl("Detalhe do erro: ExcecaoValorNegativo: " + message);
		
	}

}

