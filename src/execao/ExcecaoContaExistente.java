package execao;
import geral.Utilitarios;

public class ExcecaoContaExistente extends RuntimeException {
	private static Utilitarios u = new Utilitarios();

	public ExcecaoContaExistente(String message) {
		// super(message);
		u.pl(u.t(15, "*"));
		u.pl("Ocorreu um erro na criacao da conta. Tente novamente.");
		u.p("Detalhe do erro: ExcecaoContaExistente: " + message);
		u.pl(u.t(15, "*"));
	}
}
