package execao;
import geral.Utilitarios;

@SuppressWarnings("serial")
public class ExcecaoNumeroInvalido extends Exception {
	private static Utilitarios u = new Utilitarios();

	public ExcecaoNumeroInvalido(String message) {
		super(message);
		// u.p("Detalhe do erro: ExcecaoNumeroInvalido: " + message);
	}

}
