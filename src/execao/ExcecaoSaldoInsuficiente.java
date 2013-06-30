package execao;
import geral.Utilitarios;

@SuppressWarnings("serial")
public class ExcecaoSaldoInsuficiente extends Exception {
	private static Utilitarios u = new Utilitarios();

	public ExcecaoSaldoInsuficiente(String message) {
		super(message);
		// u.p("Detalhe do erro: ExcecaoSaldoInsuficiente: " + message);
	}

}
