package execao;
import geral.Utilitarios;

public class ExcecaoTipoConta extends RuntimeException {
	private static Utilitarios u = new Utilitarios();

	public ExcecaoTipoConta(String message) {
		// super(message);
		u.pl(u.t(15, "*"));
		u.pl("Ocorreu um erro na operação. Tente novamente.");
		u.pl("Detalhe do erro: ExcecaoTipoConta: " + message);
		u.pl(u.t(15, "*"));
	}

}

