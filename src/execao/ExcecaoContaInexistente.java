package execao;
import geral.Utilitarios;

public class ExcecaoContaInexistente extends RuntimeException {
	private static Utilitarios u = new Utilitarios();

	public ExcecaoContaInexistente(String message) {
		// super(message);
		u.pl(u.t(15, "*"));
		u.pl("Ocorreu um erro ao realizar essa operação. Tente novamente.");
		u.pl("Detalhe do erro: ExcecaoContaExistente: " + message);
		u.pl(u.t(15, "*"));
	}
}
