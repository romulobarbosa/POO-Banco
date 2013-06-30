package execao;
import geral.Utilitarios;

@SuppressWarnings("serial")
public class ExcecaoTipoConta extends RuntimeException {
	private static Utilitarios u = new Utilitarios();

	public ExcecaoTipoConta(String message) {
		super(message);
		// u.pl("Detalhe do erro: ExcecaoTipoConta: " + message);
	}

}

