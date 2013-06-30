package execao;
import geral.Utilitarios;

@SuppressWarnings("serial")
public class ExcecaoOpcaoInvalida extends Exception {
	private static Utilitarios u = new Utilitarios();

	public ExcecaoOpcaoInvalida(String message) {
		super(message);
		// u.p("Detalhe do erro: ExcecaoOpcaoInvalida: " + message);
	}
}

