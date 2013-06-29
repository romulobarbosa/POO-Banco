package execao;
import geral.Utilitarios;

public class ExcecaoContaExistente extends RuntimeException {
	private static Utilitarios u = new Utilitarios();

	public ExcecaoContaExistente(String message) {
		// super(message);
		u.pl(u.t(15, "*"));
		u.pl("Ocorreu um erro na validacao da opcao. Tente novamente.");
		u.p("Detalhe do erro: ExcecaoOpcaoInvalida: " + message);
		u.pl(u.t(15, "*"));
	}

}
