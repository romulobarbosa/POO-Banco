package execao;
import geral.Utilitarios;

@SuppressWarnings("serial")
public class ExcecaoContaInexistente extends RuntimeException {
	private static Utilitarios u = new Utilitarios();

	public ExcecaoContaInexistente(String message) {
		super(message);
		// u.pl("Detalhe do erro: ExcecaoContaExistente: " + message);
	}
}
