package execao;
import geral.Utilitarios;

@SuppressWarnings("serial")
public class ExcecaoContaExistente extends Exception {
	private static Utilitarios u = new Utilitarios();

	public ExcecaoContaExistente(String message) {
		super(message);
		// u.p("Detalhe do erro: ExcecaoContaExistente: " + message);
	}
}
