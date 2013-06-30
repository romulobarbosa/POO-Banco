package execao;
import geral.Utilitarios;

public class ExcecaoOpcaoInvalida extends RuntimeException {
	private static Utilitarios u = new Utilitarios();

	public ExcecaoOpcaoInvalida(String message) {
		// super(message);
		u.pl(u.t(15, "*"));
		u.pl("Ocorreu um erro na validacao da opcao. Tente novamente.");
		u.p("Detalhe do erro: ExcecaoOpcaoInvalida: " + message);
		u.pl(u.t(15, "*"));
	}
}

