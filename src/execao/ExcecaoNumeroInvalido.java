package execao;
import geral.Utilitarios;

public class ExcecaoNumeroInvalido extends RuntimeException {
	private static Utilitarios u = new Utilitarios();

	public ExcecaoNumeroInvalido(String message) {
		// super(message);
		u.pl(u.t(15, "*"));
		u.pl("Ocorreu um erro na criacao da conta. Tente novamente.");
		u.p("Detalhe do erro: ExcecaoNumeroInvalido: " + message);
		u.pl(u.t(15, "*"));
	}

}
