package execao;

@SuppressWarnings("serial")
public class ExcecaoSaldoInsuficiente extends Exception {

	public ExcecaoSaldoInsuficiente(String message) {
		super("ExcecaoSaldoInsuficiente: " + message);
	}

}