package execao;
import geral.Utilitarios;

public class ExcecaoSaqueInvalido extends RuntimeException {
	private static Utilitarios u = new Utilitarios();

	public ExcecaoSaqueInvalido(String message) {
		// super(message);
		u.pl(u.t(15, "*"));
		u.pl("Ocorreu um erro no saque. Tente novamente.");
		u.pl("Detalhe do erro: ExcecaoSaqueInvalido: " + message);
		u.pl(u.t(15, "*"));
	}

}

