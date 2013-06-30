package execao;
import geral.Utilitarios;

public class ExcecaoSaldoInsuficiente extends RuntimeException {
	private static Utilitarios u = new Utilitarios();

	public ExcecaoSaldoInsuficiente(String message) {
		// super(message);
		u.pl(u.t(15, "*"));
		u.pl("Ocorreu um erro ao realizar a consulta. Tente novamente.");
		u.p("Detalhe do erro: ExcecaoSaldoInsuficiente: " + message);
		u.pl(u.t(15, "*"));
	}

}
