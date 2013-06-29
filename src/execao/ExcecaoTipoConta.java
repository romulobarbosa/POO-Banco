package execao;
import geral.Utilitarios;

public class ExcecaoTipoConta extends RuntimeException {
	private static Utilitarios u = new Utilitarios();

	public ExcecaoTipoConta(String message) {
		// super(message);
		u.pl(u.t(15, "*"));
		u.pl("");
		u.pl("");
		u.pl(u.t(15, "*"));
	}

}

