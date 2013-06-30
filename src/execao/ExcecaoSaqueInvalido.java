package execao;
import geral.Utilitarios;

@SuppressWarnings("serial")
public class ExcecaoSaqueInvalido extends RuntimeException {
	private static Utilitarios u = new Utilitarios();

	public ExcecaoSaqueInvalido(String message) {
		super(message);
		// u.pl("Detalhe do erro: ExcecaoSaqueInvalido: " + message);
	}

}

