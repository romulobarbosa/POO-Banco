package execao;
import geral.Utilitarios;

public class ExcecaoFaltaEspaco extends RuntimeException {
	private static Utilitarios u = new Utilitarios();

	public ExcecaoFaltaEspaco(String message) {
		// super(message);
		u.pl(u.t(15, "*"));
		u.pl("Ocorreu um erro na criacao da conta. Tente novamente.");
		u.pl("Detalhe do erro: ExcecaoFaltaEspaco: " + message);
		u.pl(u.t(15, "*"));
	}
	
}
